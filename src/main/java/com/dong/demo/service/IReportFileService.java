package com.dong.demo.service;

import com.dong.demo.entity.ReportAttachment;
import com.dong.demo.entity.ReportZip;
import com.dong.demo.vo.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IReportFileService {
/*
    *//**
     * 附件上传
     * @param reportAttachmentV  附件参数
     * @param file               上传附件
     *//*
    ReportAttachment uploadAttachment(ReportAttachmentV reportAttachmentV, MultipartFile file);

    *//**
     * 删除附件
     * @param attachmentId  附件id
     *//*
    List<ReportAttachment> deleteAttachment(String attachmentId);

    *//**
     * 下载附件
     * @param
     * @return
     *//*
    ResponseEntity<InputStreamResource> downloadAttachment(String attachmentId, HttpServletResponse response);

    *//**
     * 下载附件链接
     * @param
     * @return
     *//*
    ReportAttachment downloadLinkAttachment(String attachmentId);


    *//**
     * 获取附件信息
     * @param attachmentUuid  附件的uuid
     *//*
    List<ReportAttachment> getAttachments(String attachmentUuid);

    *//**
     *  多条公文选择类型下载(大文件)
     * @param reportZipPV  选择的大文件信息
     *//*
    void packageZip(ReportZipPV reportZipPV, LoginUser loginUser);

    *//**
     * 我的下载
     *//*
    PageRV<ReportZip> mineDownload(PageV pageV, LoginUser loginUser);

    *//**
     * 下载zip文件
     * @param
     * @return
     *//*
    ResponseEntity<InputStreamResource> downloadZip(String zipUuid, HttpServletResponse response);


    *//**
     * 下载zip文件
     * @param
     * @return
     *//*
    ResponseEntity<InputStreamResource> downloadSingleZip(ReportZipPV reportZipPV, HttpServletResponse response);

    *//**
     * 下载文件 公共服务
     * @param response  请求返回的response
     *//*
    ResponseEntity<InputStreamResource> downloadFile(HttpServletResponse response, File file, String fileName) throws IOException;

    *//**
     * 服务器上的文件定时传seafile上
     *//*
    void attachmentUploadSeaFile();

    *//**
     * 服务器上下载文件夹清理
     *//*
    void attachmentDownloadClean();*/
}
