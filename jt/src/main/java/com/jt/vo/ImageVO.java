package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImageVO {
    private String virtualPath;//文件的动态路径
    private String urlPath;  //文件的网络路径
    private String fileName; //文件名称

}
