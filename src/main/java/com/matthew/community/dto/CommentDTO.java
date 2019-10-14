package com.matthew.community.dto;

import com.matthew.community.model.Comment;
import com.matthew.community.model.User;
import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/3 15:54
 * @Version 1.0
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}
