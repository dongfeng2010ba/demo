package com.dong.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cp_report_attachment")
public class ReportAttachment implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("attachmentId唯一id")
    @TableId(value = "attachment_id", type = IdType.AUTO)
    private Long attachmentId;

    @ApiModelProperty("附件UUID")
    private String attachmentUuid;


    @ApiModelProperty("AttachmentType数据字典sendTypes、receiveTypes、referTypes")
    private Integer attachmentType;


    @ApiModelProperty("顺序号")
    private Integer attachmentSerial;

    /**
     * 发文、收文、参阅件的附件id
     */
    /*@JsonIgnore
    private String reportId;*/

    /**
     * 文件seafile的id(文件新名称uuid)
     */
    @ApiModelProperty("服务器文件名称")
    private String seafileId;

    /**
     * FileStatus
     */
    @JsonIgnore
    private Integer fileStatus;

    /**
     * 文件存储目录
     */
    @JsonIgnore
    private String fileDir;


    @ApiModelProperty("文件原始名称")
    private String fileOriginName;


    @ApiModelProperty("文件大小")
    private Long fileSize;

    @ApiModelProperty("文件下载地址")
    @TableField(exist = false)
    private String url;


    public String filePath(){
        return this.getFileDir() + this.getSeafileId();
    }

}
