package com.matthew.community.controller;

import com.matthew.community.dto.PaginationDTO;
import com.matthew.community.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/6 15:19
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Resource
    private QuestionService questionService;

    @GetMapping("/")
    public String index( Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "2") Integer size
                        ) {
        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
