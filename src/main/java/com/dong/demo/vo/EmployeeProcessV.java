package com.dong.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class EmployeeProcessV implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("员工id")
    private String employeeId;

    @ApiModelProperty("员工姓名")
    private String employeeName;

    @ApiModelProperty("部门id")
    private String departmentId;

    @ApiModelProperty("部门名称")
    private String departmentName;

}
