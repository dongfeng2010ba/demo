package com.dong.properties;

import com.dong.demo.entity.ReportAttachment;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

//@Data
//@Component
//@ConfigurationProperties(prefix = "seafile")
public class SeaFileProperties {

    /**
     * 系统标识
     */
    private  String systemId;
    /**
     * 文件服务器地址
     */
    private  String host;
    /**
     * 文件服务器端口号
     */
    private  String port;

    /**
     *上传文件路径
     */
    private  String upload;
    /**
     *查询文件路径
     */
    private  String query;
    /**
     *参数
     */
    private  String attaDomain;
    private  String domainId;
    private  String commTreeId;
    private  String upFile;
    /**
     *拼接上传文件请求地址
     */
    public String uploadUrl(){
        return host + ":" + port + upload;
    }

    /**
     *拼接查询文件请求地址
     */
    public String queryUrl(){
        return host + ":" + port + query;
    }

    /**
     *封装上传文件请求参数
     */
    public MultiValueMap<String, Object> uploadParamAssemble(ReportAttachment reportAttachment){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add(attaDomain, reportAttachment.getAttachmentType().toString());
        param.add(domainId, reportAttachment.getSeafileId());
        param.add(commTreeId, systemId);
        param.add(upFile, new FileSystemResource(Paths.get(reportAttachment.filePath()).toFile()));
        return param;
    }

    /**
     *封装查询文件请求参数
     */
    public Map<String, Object> queryParamAssemble(ReportAttachment reportAttachment){
        Map<String, Object> param = new HashMap<>();
        param.put(attaDomain, reportAttachment.getAttachmentType().toString());
        param.put(domainId, reportAttachment.getSeafileId());
        param.put(commTreeId, systemId);
        return param;
    }

}

