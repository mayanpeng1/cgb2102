package com.jt.service.impl;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileServiceImpl implements FileService {
    //属性动态赋值!!!
    @Value("${file.localDir}")//spel表达式
    private String localDir;//本地路径
    @Value("${file.urlPath}")
    private String urlPath;//网络虚拟路径
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
        //1.检验图片类型  ??  jpg|png|gif
        String fileName = file.getOriginalFilename();
        //将所有字符全部转化为小写之后检验    a.jpg  A.JPG
        fileName = fileName.toLowerCase();
        if(!fileName.matches("^.+\\.(jpg|png|gif)$")){
            return null;
        }
        //2.恶意程序校验   通过宽度/高度进行判断
        //将文件强制转化为图片
        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            if (width==0 || height ==0){
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // 保存文件的子级文件夹
        //获取当前时间年月
        LocalDateTime now = LocalDateTime.now();
        String dateDir = DateTimeFormatter.ofPattern("/yyyy/MM/dd/").format(now);
        //将本地路径 和 时间路径 拼接  组成 文件夹目录名称
        String fileDir = localDir+dateDir;
        File dirFile = new File(fileDir);
        //创建文件夹
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        return null;
    }
}
