package com.matthew.community.dto;

import com.matthew.community.model.User;
import lombok.Data;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/17 18:43
 * @Version 1.0
 */
@Data
public class NotificationDTO {
    private Long id;
    private Integer status;
    private Long gmtCreate;
    private Long notifier;
    private Long outerid;
    private String notifierName;
    private String outerTitle;
    private String typeName;
    private int type;
}
