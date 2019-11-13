package com.dong.demo.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel
public class PageRV<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分页集合")
    List<T> recordList;

    @ApiModelProperty("总页数")
    private Long pageNo;

    @ApiModelProperty("总记录数")
    private Long pageTotal;

    @ApiModelProperty("当前页码")
    private Long currentPage;

    @ApiModelProperty("每页条数")
    private Long pageSize;

    public PageRV<T> iPage(IPage<T> iPage){
        this.setPageNo(iPage.getPages());
        this.setPageTotal(iPage.getTotal());
        this.setRecordList(iPage.getRecords());
        this.setCurrentPage(iPage.getCurrent());
        this.setPageSize(iPage.getSize());
        return this;
    }

}

