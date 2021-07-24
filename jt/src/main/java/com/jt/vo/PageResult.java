package com.jt.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class PageResult {
    private String query;//用户查询条件
    private Integer pageNum; //分页页数
    private Integer pageSize; //分页条数
    private Long total; //数据总数
    private Object rows; //分页结果
}
