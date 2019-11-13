package com.dong.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel
public class ReportZipPV implements Serializable {

    private static final long serialVersionUID = 1L;

   /* @ApiModelProperty("公文类型")
    private Integer reportType;*/

    @ApiModelProperty("信息类型")
    private Integer infoType;

    @ApiModelProperty("批量公文ids")
    private List<String> reportIds;

    @ApiModelProperty("公文类型")
    private List<Integer> attachmentTypes;

}