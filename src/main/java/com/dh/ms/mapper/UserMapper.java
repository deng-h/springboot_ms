package com.dh.ms.mapper;
import com.baomidou.mybatisplus.core.injector.methods.DeleteByMap;
import org.apache.ibatis.annotations.Param;

import com.dh.ms.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author dell
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-11-05 10:40:52
* @Entity com.dh.ms.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




