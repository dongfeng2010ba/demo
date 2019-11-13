package com.dong.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cp_report_zip")
public class ReportZip implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * zip文件UUID
     */
    @TableId(type= IdType.UUID)
    private String zipUuid;

    /**
     * 员工id
     */
    private String employeeId;

    /**
     * 0-未生成 1-已生成
     */
    private Integer zipStatus;

    /**
     * zip状态描述
     */
    private String zipDesc;

    /**
     * zip存储目录
     */
    private String zipPath;

    /**
     * zip名称
     */
    private String zipName;

    /**
     * 生成时间
     */
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    /**
     * 创建时间
     */
    @TableField(fill= FieldFill.INSERT)
    private LocalDateTime creatTime;


}

