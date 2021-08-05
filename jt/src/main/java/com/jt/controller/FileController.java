package com.jt.controller;

import com.jt.vo.SysResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    /**
     * 文件上传入门案例
     * URL: /file/upload
     *
     */
    @PostMapping("/upload")
    public SysResult upload(MultipartFile file){
        return SysResult.success();
    }
}
