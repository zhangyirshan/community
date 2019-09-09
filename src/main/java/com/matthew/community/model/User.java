package com.matthew.community.model;

import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/8 10:03
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
}
