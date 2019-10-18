package com.matthew.community.controller;

import com.matthew.community.dto.FileDTO;
import com.matthew.community.provider.UCloudProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/18 12:19
 * @Version 1.0
 */
@Controller
public class FileController {

    @Resource
    private UCloudProvider uCloudProvider;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpServletRequest.getFile("editormd-image-file");
        try {
            uCloudProvider.upload(file.getInputStream(), file.getContentType(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/loading.gif");
        return fileDTO;
    }
}
