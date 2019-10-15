package com.matthew.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/15 15:41
 * @Version 1.0
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
