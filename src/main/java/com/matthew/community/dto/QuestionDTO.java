package com.matthew.community.dto;

import com.matthew.community.model.User;
import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/12 18:28
 * @Version 1.0
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
