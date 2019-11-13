package com.dong.properties;

import com.common.utils.Constant;
import com.dong.enums.EmployeeType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


//@Data
//@Component
//@ConfigurationProperties(prefix = "sso")
public class SSOProperties {

    private  String host;

    private  String port;

    private  String verify;

    private  String token;

    private  String tenants;

    private  String loginUser;

    private String role;

    private String departTree;

    private String departUser;

    private String user;


    public String tokenUrl(){ return host + ":" + port + token;}

    public String tenantsUrl(){return host + ":" + port + tenants;}

    public String verifyUrl(){return host + ":" + port + verify;}

    public String loginUserUrl(){return host + ":" + port + loginUser;}

    public String roleUrl(){return host + ":" + port + role+"?groupTypeCode=" + Constant.SSO_SYS_CODE;}

    public String departTreeUrl(){return host + ":" + port + departTree + "0";}

    public String departTreeChildCompanyUrl(){return host + ":" + port + departTree + "1";}

    public String departUserUrl(String departmentId){
        return host + ":" + port + departUser.replaceAll("departmentId",departmentId);
    }

    public String departPositionUserUrl(String departmentId, EmployeeType employeeType){
        //岗位 postCode "部门领导" "部门副领导" "普通员工"
        return host + ":" + port + departUser.replaceAll("departmentId",departmentId) + "?postCode=" +employeeType.getDesc();
    }


    public String userUrlbyIds(List<String> idList){
        return host + ":" + port + user + String.join(",",idList);
    }

    public String userUrl(String id){
        // return host + ":" + port + user + String.join(",",id);
        return host + ":" + port + user + id;
    }

}

