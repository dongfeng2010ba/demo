package com.dong.demo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 当前登录员工id
     */
    private String id;

    /**
     * 当前登录员工登陆名
     */
    private String username;

    /**
     * 当前登录员工姓名
     */
    private String name;

    /**
     * 当前登录员工身份证
     */
    private String identityCode;

    /**
     * 当前登录员工手机号
     */
    private String mobilePhone;

    /**
     * 当前登陆头
     */
    private LoginHeader loginHeader;


    /*"id": "94499df173cb4e53afee1543a1cb9284",
            "username": "JT901",
            "name": "徐厚军",
            "identityCode": "",
            "postCode": "部门领导",
            "mobilePhone": "",
*/
}

