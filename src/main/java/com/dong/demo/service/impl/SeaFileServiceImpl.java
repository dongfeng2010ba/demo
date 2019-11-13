package com.dong.demo.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.dong.exception.RException;
import com.dong.enums.REnum;
import com.dong.properties.SeaFileProperties;
import com.dong.demo.entity.ReportAttachment;
import com.dong.demo.service.ISeaFileService;
import com.dong.demo.vo.*;
import com.common.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @Description: 文件上传下载服务实现类
 * @author: songguoxi
 * @Date: 2019/8/1 10:14
 */

@Service
public class SeaFileServiceImpl implements ISeaFileService {

    private final Logger logger = LoggerFactory.getLogger(SeaFileServiceImpl.class);

   /* @Autowired
    private SeaFileProperties seaFileProperties;


    @Autowired
    private RestTemplate restTemplate;*/


    @Override
    public SeaFileUploadResultV uploadSeaFile(ReportAttachment reportAttachment) {
/*
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(seaFileProperties.uploadParamAssemble(reportAttachment), new HttpHeaders());
        //发起上传
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(seaFileProperties.uploadUrl(), HttpMethod.POST, httpEntity, String.class);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("执行SeaFile单文件上传错误，附件信息{}",reportAttachment);
            throw new RException(REnum.SEAFILE_UPLOAD_ERROR);
        }
        //请求失败
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            logger.error("执行SeaFile单文件上传返回Http状态码非200，附件信息{}", reportAttachment);
            //异步上传，文件具体状态查看数据库
            throw new RException(REnum.SEAFILE_UPLOAD_ERROR);
        }
        //获取响应结果
        SeaFileResultRV<List<SeaFileUploadResultV>> seaFileResultRV = ConvertUtils.jsonToObjByType(responseEntity.getBody(),
                new TypeReference<SeaFileResultRV<List<SeaFileUploadResultV>>>(){});
        if (seaFileResultRV==null || seaFileResultRV.getResultCode()!=HttpStatus.OK.value()) {
            logger.error("执行SeaFile单文件上传返回的HTTP Body解析失败，附件信息{}", reportAttachment);
            //异步上传，文件具体状态查看数据库
            throw new RException(REnum.SEAFILE_UPLOAD_ERROR);
        }
        return seaFileResultRV.getResultData().get(seaFileResultRV.getResultData().size()-1);*/

        SeaFileUploadResultV seaFileUploadResultV = new SeaFileUploadResultV();
        return seaFileUploadResultV;
    }


    @Override
    public SeaFileInfoV getSeaFile(ReportAttachment reportAttachment) {
  /*      HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8); //json格式提交
        //封装请求参数
        Map<String, Object> param = seaFileProperties.queryParamAssemble(reportAttachment);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(param, requestHeaders);
        //发起请求
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(seaFileProperties.queryUrl(), HttpMethod.POST, httpEntity, String.class);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("查询SeaFile文件错误，附件信息{}", reportAttachment);
            throw new RException(REnum.SEAFILE_QUERY_ERROR);
        }
        //请求失败
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            logger.error("查询SeaFile文件返回Http状态码非200，附件信息{}", reportAttachment);
            throw new RException(REnum.SEAFILE_QUERY_ERROR);
        }
        //获取响应结果
        List<SeaFileInfoV> result = null;
        SeaFileResultRV<List<SeaFileInfoV>> seaFileResultRV = ConvertUtils.jsonToObjByType(responseEntity.getBody(),
                new TypeReference<SeaFileResultRV<List<SeaFileInfoV>>>(){});

        //解析失败
        if (null == seaFileResultRV || seaFileResultRV.getResultCode() != HttpStatus.OK.value()) {
            logger.error("查询SeaFile文件返回HTTP Body解析失败，附件信息{}", reportAttachment);
            throw new RException(REnum.SEAFILE_QUERY_ERROR);
        }
        //
        if(seaFileResultRV.getResultData().isEmpty()){
            logger.error("查询SeaFile文件返回为空，附件信息{}", reportAttachment);
            throw new RException(REnum.SEAFILE_QUERY_ERROR);
        }
        return seaFileResultRV.getResultData().get(seaFileResultRV.getResultData().size()-1);*/
        SeaFileInfoV SeaFileInfoV = new SeaFileInfoV();
        return SeaFileInfoV;
    }


    @Override
    public void downLoadSeaFile(String downloadUrl, ReportAttachment reportAttachment) {
        Instant now = Instant.now();
        try {
            if (!Files.exists(Paths.get(reportAttachment.getFileDir()))) {
                Files.createDirectories(Paths.get(reportAttachment.getFileDir()));
            }
            //定义请求头的接收类型
            RequestCallback requestCallback = request -> request.getHeaders()
                    .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
            // getForObject会将所有返回直接放到内存中,使用流来替代这个操作
            ResponseExtractor<Void> responseExtractor = response -> {
                File localFile = Paths.get(reportAttachment.filePath()).toFile();
                //如果文件存在删除重新下载
                if (localFile.exists()) {
                    localFile.delete();
                }
                Files.copy(response.getBody(), Paths.get(reportAttachment.filePath()));
                return null;
            };
            //restTemplate.execute(downloadUrl, HttpMethod.GET, requestCallback, responseExtractor);
        } catch (Exception e) {
            logger.error("下载SeaFile文件失败，filePath{}，downloadUrl{}", reportAttachment.filePath(),downloadUrl,e);
            throw new RException(REnum.SEAFILE_DOWNLOAD_ERROR);

        }
        logger.info("[下载文件] 完成,耗时:{}", ChronoUnit.MILLIS.between(now, Instant.now()));
    }

    /**
     * 创建或获取下载文件夹的路径
     *
     * @param url
     * @param targetDir
     * @return
     */
    private String getAndCreateDownloadDir(String url, String targetDir) throws IOException {
        String filename = url.substring(url.lastIndexOf("/") + 1);
        int i = 0;
        if ((i = url.indexOf("?")) != -1) {
            filename = filename.substring(0, i);
        }
        if (!Files.exists(Paths.get(targetDir))) {
            Files.createDirectories(Paths.get(targetDir));
        }
        return targetDir.endsWith("/") ? targetDir + filename : targetDir + "/" + filename;
    }

}


