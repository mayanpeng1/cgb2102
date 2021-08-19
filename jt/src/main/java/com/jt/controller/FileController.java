package com.jt.controller;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public SysResult uploadFile(MultipartFile file) throws IOException{
        ImageVO imageVO = fileService.upload(file);
        //如果imageVO 为null  说明文件上传失败
        if(imageVO==null){
            return SysResult.fall();
        }
        return SysResult.success(imageVO);
    }

    //实现文件删除
    @DeleteMapping("/deleteFile")
    public SysResult deleteFile(String virtualPath){
        File file = new File(virtualPath);
        //删除文件
        file.delete();
        return SysResult.success();
    }
    /**
     * 文件上传入门案例
     * URL: /file/upload
     * 返回值 : SysResult(imageVO)
     * 步骤:
     *      1.获取文件名称
     *      2.指定具体上传路径
     *      3.拼接文件的全路径
     *      4.实现上传
     */
    //@PostMapping("/upload")
    public SysResult upload(MultipartFile file) throws IOException {
        //1.获取文件名称
        String fileName = file.getOriginalFilename();
        //2.定义上传路径   绝对路径
        String fileDir = "D:/JT-SOFT/image";
        File dirFile = new File(fileDir);
        if(!dirFile.exists()){
            //如果文件不存在,则应该创建一个新的目录
            dirFile.mkdirs();//多级目录创建
        }

        //3.指定文件双穿的全部路径   目录/文件
        String filePath = fileDir+"/"+fileName;
        //4.实现文件上传
        file.transferTo(new File(filePath));

        return SysResult.success();
    }
}
