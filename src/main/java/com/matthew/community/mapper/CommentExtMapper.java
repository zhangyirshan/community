package com.matthew.community.mapper;

import com.matthew.community.model.Comment;

public interface CommentExtMapper {

    int incCommentCount(Comment comment);
}