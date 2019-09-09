package com.matthew.community.controller;

import com.matthew.community.mapper.UserMapper;
import com.matthew.community.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/6 15:19
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.fingByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
