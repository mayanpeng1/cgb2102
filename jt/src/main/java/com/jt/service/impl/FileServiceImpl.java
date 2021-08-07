package com.jt.service.impl;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    /**
     * 业务说明:
     *      1.是否为图片类型
     *      2.防止恶意程序   xxx.exe.jpg
     *      3.分文件目录存储 hash  date  yyyy/MM/dd
     *      4.重新设定文件名称 UUID
     *      5.实现文件上传
     *      6.封装VO对象之后返回
     * @param file
     * @return
     */
    @Override
    public ImageVO upload(MultipartFile file) {
        //1.检验图片类型

        return null;
    }
}
