package com.matthew.community.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/20 12:28
 * @Version 1.0
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
