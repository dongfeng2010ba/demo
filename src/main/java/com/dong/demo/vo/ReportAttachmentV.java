package com.dong.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "删除文件操作需要给id 类型 和序号 前端必须返回才能进行下一步操作")
public class ReportAttachmentV implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("附件uuid（上传/删除附件必填）")
    private String attachmentUuid;

    @ApiModelProperty("AttachmentType枚举类型（上传/删除附件必填）")
    private Integer attachmentType;

    @ApiModelProperty("顺序号（上传/删除附件必填）")
    private Integer attachmentSerial;

    @ApiModelProperty("文件原始名称")
    private String fileOriginName;

    @ApiModelProperty("文件大小")
    private Long fileSize;

    @ApiModelProperty("seafileId")
    private String seafileId;
}
