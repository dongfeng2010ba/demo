package com.dong.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class PageV implements Serializable {

    @ApiModelProperty("当前页码")
    public Long currentPage;

    @ApiModelProperty("每页记录数")
    public Long pageSize ;

    public PageV(){}

    public PageV(Long currentPage,Long pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
