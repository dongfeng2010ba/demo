package com.dong.demo.vo;

import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;

@Data
public class LoginHeader implements Serializable {

    /**
     * 登录后返回认证令牌
     */
    public String Authorization;

    /**
     * 登录选择的租户（以什么身份登入、集团或子公司）
     */
    public String Tenant;

    public MultiValueMap<String, String> getLoginHeader(){
        MultiValueMap<String, String> rtMultiValueMap = new LinkedMultiValueMap<String, String>();
        rtMultiValueMap.add("Authorization",Authorization);
        rtMultiValueMap.add("Tenant",Tenant);
        return rtMultiValueMap;
    }
}
