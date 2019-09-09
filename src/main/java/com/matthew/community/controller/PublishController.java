package com.matthew.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/9 18:41
 * @Version 1.0
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }
}
