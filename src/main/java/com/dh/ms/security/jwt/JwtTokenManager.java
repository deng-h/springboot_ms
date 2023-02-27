package com.dh.ms.security.jwt;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import com.dh.ms.security.userdetails.SysUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtTokenManager {

    // secret key.
    @Value("${auth.token.secret_key}")
    private String secretKey;

    /*
     *  Token validity time(seconds).
     */
    @Value("${auth.token.token_validity}")
    private long tokenValidity;

    // secret key byte array.
    private byte[] secretKeyBytes;

    private JwtParser jwtParser;

    @Autowired
    private RedisTemplate redisTemplate;

    public String createToken(Authentication authentication) {

        long now = System.currentTimeMillis();
        Date validity;
        validity = new Date(now + tokenValidity * 1000L);

        Claims claims = Jwts.claims().setSubject(authentication.getName());
        SysUserDetails userDetails = (SysUserDetails) authentication.getPrincipal();  // 获取当前用户的信息
        claims.put("userId", userDetails.getUserId());
        claims.put("username", claims.getSubject());

        Set<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        Set<String> authorities = userDetails.getPerms();
        authorities.addAll(roles);  // 将集合roles的元素追加到authorities中
        // 像这样["java.util.HashSet",["sys:user:edit","sys:user:delete","sys:user:add","ROLE_TEST","ROLE_ADMIN","ROLE_DEVELOP"]]
        // 角色信息和权限信息一起放到redis中
        redisTemplate.opsForValue().set("USER_PERMS:" + userDetails.getUserId(), authorities);
        return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(validity)
                    .signWith(Keys.hmacShaKeyFor(this.getSecretKeyBytes()), SignatureAlgorithm.HS256).compact();
    }

    public String createToken(String userName) {

        long now = System.currentTimeMillis();

        Date validity;

        validity = new Date(now + tokenValidity * 1000L);

        Claims claims = Jwts.claims().setSubject(userName);

        return Jwts.builder().setClaims(claims).setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, Keys.hmacShaKeyFor(this.getSecretKeyBytes())).compact();
    }

    public Authentication getAuthentication(String token) {
        if (jwtParser == null) {
            jwtParser = Jwts.parserBuilder().setSigningKey(this.getSecretKeyBytes()).build();
        }
        Claims claims = jwtParser.parseClaimsJws(token).getBody();

        List<GrantedAuthority> authorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList((String) claims.get("authorities"));

        SysUserDetails principal = new SysUserDetails();
        principal.setUserId(Convert.toLong(claims.get("userId")));
        principal.setUsername(Convert.toStr(claims.get("username")));

        // 权限数据过多放置在redis
        Set<String> perms = (Set<String>) redisTemplate.opsForValue().get("USER_PERMS:" + claims.get("userId"));
        if (CollUtil.isNotEmpty(perms)) {
            List<GrantedAuthority> permAuthorities = perms.stream()
                    .map(perm -> new SimpleGrantedAuthority(perm))
                    .collect(Collectors.toList());
            authorities.addAll(permAuthorities);
        }
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    public void validateToken(String token) {
        if (jwtParser == null) {
            jwtParser = Jwts.parserBuilder().setSigningKey(this.getSecretKeyBytes()).build();
        }
        jwtParser.parseClaimsJws(token);
    }

    public byte[] getSecretKeyBytes() {
        if (secretKeyBytes == null) {
            try {
                secretKeyBytes = Decoders.BASE64.decode(secretKey);
            } catch (DecodingException e) {
                secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
            }
        }
        return secretKeyBytes;
    }
}
