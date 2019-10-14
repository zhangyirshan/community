package com.matthew.community.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/22 17:48
 * @Version 1.0
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
