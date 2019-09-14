package com.matthew.community.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/7 10:07
 * @Version 1.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
