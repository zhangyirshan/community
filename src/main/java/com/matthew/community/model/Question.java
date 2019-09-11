package com.matthew.community.model;

import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/11 17:14
 * @Version 1.0
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
