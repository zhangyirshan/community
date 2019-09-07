package com.matthew.community.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/7 9:20
 * @Version 1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
