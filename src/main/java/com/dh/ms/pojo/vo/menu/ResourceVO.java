package com.dh.ms.pojo.vo.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceVO {

    private Long value;

    private String label;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<ResourceVO> children;
}

