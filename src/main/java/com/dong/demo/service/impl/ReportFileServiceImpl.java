package com.dong.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.demo.entity.ReportAttachment;
import com.dong.demo.entity.ReportZip;
import com.dong.demo.mapper.ReportAttachmentMapper;
import com.dong.demo.mapper.ReportZipMapper;
import com.dong.demo.service.IReportFileService;
import com.dong.demo.service.IReportZipService;
import com.dong.demo.service.ISeaFileService;
import com.dong.demo.vo.*;
import com.dong.enums.FileStatus;
import com.dong.enums.REnum;
import com.dong.enums.ZipStatus;
import com.dong.exception.RException;
import com.dong.properties.SSOProperties;

import com.common.utils.Constant;
import com.common.utils.UUIDUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportFileServiceImpl implements IReportFileService {

    private final Logger logger = LoggerFactory.getLogger(ReportFileServiceImpl.class);

  /*  @Autowired
    private SSOProperties reportFileProperties;*/

   /* @Autowired
    private ReportAttachmentMapper reportAttachmentMapper;*/

  /*  @Autowired
    private ReportZipMapper reportZipMapper;

    @Autowired
    private ISeaFileService iSeaFileService;

    @Autowired
    private IReportZipService iReportZipService;*/

    /**
     * 服务器端文件上传目录
     */
    @Value(value = "${reportfile.uploadDir}")
    private String uploadDir;

    /**
     * 服务器端文件下载目录
     */
    @Value(value = "${reportfile.downloadDir}")
    private String downloadDir;


    /*@Override
    @Transactional
    public ReportAttachment uploadAttachment(ReportAttachmentV reportAttachmentV, MultipartFile file) {
       ReportAttachment reportAttachment = new ReportAttachment();
       *//*  BeanUtils.copyProperties(reportAttachmentV,reportAttachment);
        reportAttachment.setFileOriginName(file.getOriginalFilename());
        if(reportAttachmentMapper.selectCount(new LambdaQueryWrapper<>(reportAttachment))>0){
            throw new RException(REnum.REPORT_UPLOAD_REPEAT);//uuid 类型，同样的名字是否有记录
        }

        //获取当前uuid 类型 最大序号+1，若没有记录，初始化为1
        if(reportAttachmentMapper.selectCount(new LambdaQueryWrapper<ReportAttachment>().eq(ReportAttachment::getAttachmentUuid,reportAttachmentV.getAttachmentUuid()))> 0 ){
            reportAttachment.setAttachmentSerial((reportAttachmentMapper.maxAttachmentSerial(reportAttachmentV.getAttachmentUuid()))+1);
        }else{
            reportAttachment.setAttachmentSerial(1);
        }

        reportAttachment.setSeafileId(UUIDUtils.getUUID()+ "."+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1));
        reportAttachment.setFileStatus(FileStatus.TEMP.getCode());
        reportAttachment.setFileDir(uploadDir);
        reportAttachment.setFileSize(file.getSize());

        //处理上传文件
        try {
            if (!Files.exists(Paths.get(reportAttachment.getFileDir()))) {
                Files.createDirectories(Paths.get(reportAttachment.getFileDir()));
            }
            File localFile = Paths.get(reportAttachment.filePath()).toFile();
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("上传文件到本地服务器处理失败");
            logger.info("reportAttachment===================>"+reportAttachment);
            throw new RException(REnum.REPORT_FILE_SERVER);
        }
        reportAttachmentMapper.insert(reportAttachment);*//*
        return reportAttachment;
    }

    @Override
    @Transactional
    public List<ReportAttachment> deleteAttachment(String attachmentId) {
        ReportAttachment reportAttachment = reportAttachmentMapper.selectById(attachmentId);
        if(reportAttachment == null){
            throw new RException(REnum.ATTACHMENT_DELETE_EXIST);
        }
        reportAttachmentMapper.deleteById(attachmentId);
        LambdaQueryWrapper<ReportAttachment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ReportAttachment::getAttachmentUuid, reportAttachment.getAttachmentUuid());
        lambdaQueryWrapper.orderByAsc(ReportAttachment::getAttachmentSerial);
        return reportAttachmentMapper.selectList(lambdaQueryWrapper);

    }



    @Override
    public List<ReportAttachment> getAttachments(String attachmentUuid){
        LambdaQueryWrapper<ReportAttachment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ReportAttachment::getAttachmentUuid,attachmentUuid);
        lambdaQueryWrapper.orderByAsc(ReportAttachment::getAttachmentSerial);
        return reportAttachmentMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public void packageZip(ReportZipPV reportZipPV, LoginUser loginUser){
        ReportZip reportZip = new ReportZip();
        reportZip.setEmployeeId(loginUser.getId());
        reportZip.setZipStatus(ZipStatus.INIT.getCode());
        reportZip.setZipDesc(ZipStatus.INIT.getDesc());
        reportZip.setZipName(UUIDUtils.getUUID());
        reportZip.setZipPath(downloadDir + reportZip.getZipName() + Constant.ZIP_SUFFIX);
        reportZipMapper.insert(reportZip);
        iReportZipService.asyncBatchDownLoadAndCreateZipFile(reportZipPV,reportZip);
    }


    @Override
    public PageRV<ReportZip> mineDownload(PageV pageV, LoginUser loginUser){
        PageRV<ReportZip> pageRV = new PageRV<>();
        LambdaQueryWrapper<ReportZip> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ReportZip::getEmployeeId,loginUser.getId());
        lambdaQueryWrapper.orderByDesc(ReportZip::getGmtModified);
        Page<ReportZip> page = new Page<>(pageV.getCurrentPage(), pageV.getPageSize());
        IPage<ReportZip> iPage = reportZipMapper.selectPage(page, lambdaQueryWrapper);
        return pageRV.iPage(iPage);
    }

    @Override
    public ResponseEntity<InputStreamResource> downloadAttachment(String attachmentId, HttpServletResponse response) {
        ReportAttachment reportAttachment = reportAttachmentMapper.selectById(attachmentId);
        if(reportAttachment == null){throw new RException(REnum.FILE_NO_ATTACHMENT);}
        if(reportAttachment.getFileStatus()== FileStatus.SEAFILE.getCode()){ //在seafile上则直接下载还原成reportAttachment信息
            SeaFileInfoV seaFileInfoV = iSeaFileService.getSeaFile(reportAttachment);
            iSeaFileService.downLoadSeaFile(seaFileInfoV.getDownloadUrl(), reportAttachment);
        }

        ResponseEntity<InputStreamResource> responseEntity = null;
        try{
            responseEntity = this.downloadFile(response,Paths.get(reportAttachment.filePath()).toFile() ,reportAttachment.getFileOriginName());
        }catch(IOException e){
            throw new RException(REnum.FILE_DOWNLOAD_ERROR);
        }
        return responseEntity;
    }


    @Override
    public ReportAttachment downloadLinkAttachment(String attachmentId){
        ReportAttachment reportAttachment = reportAttachmentMapper.selectById(attachmentId);
        reportAttachment.setUrl(Constant.FILE_PATH + reportAttachment.getSeafileId());
        return reportAttachment;
    }



    @Override
    public ResponseEntity<InputStreamResource> downloadZip(String zipUuid, HttpServletResponse response) {
        ReportZip reportZip = reportZipMapper.selectById(zipUuid);
        if(reportZip == null){throw new RException(REnum.FILE_NO_ZIP);}
        if(reportZip.getZipStatus() != ZipStatus.EXIST.getCode()){
            throw new RException(REnum.FILE_NO_ZIP_EXIST);
        }

        ResponseEntity<InputStreamResource> responseEntity = null;
        try{
            responseEntity = this.downloadFile(response,Paths.get(reportZip.getZipPath()).toFile() ,reportZip.getZipName()+Constant.ZIP_SUFFIX);
        }catch(IOException e){
            throw new RException(REnum.FILE_DOWNLOAD_ZIP_ERROR);
        }
        return responseEntity;
    }


    @Override
    public ResponseEntity<InputStreamResource> downloadSingleZip(ReportZipPV reportZipPV, HttpServletResponse response){
        String zipName = UUIDUtils.getUUID();
        String path = iReportZipService.batchDownLoadAndCreateZipFile(reportZipPV,zipName);
        ResponseEntity<InputStreamResource> responseEntity = null;
        try{
            responseEntity = this.downloadFile(response,Paths.get(path).toFile() ,zipName+Constant.ZIP_SUFFIX);
        }catch(IOException e){
            throw new RException(REnum.FILE_DOWNLOAD_ZIP_ERROR);
        }
        return responseEntity;

    }


    @Override
    public ResponseEntity<InputStreamResource> downloadFile(HttpServletResponse response, File file, String fileName) throws IOException {
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        fileName = fileName.trim().replaceAll(" ","");//去掉空格，防止文件名空格反编码成+号
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers","Content-Disposition");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        try{
            headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        }catch (UnsupportedEncodingException e){
            throw new RException(REnum.ZIP_LINK_NOT_EXIST);
        }

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength((int) file.length())
                //.contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(fileSystemResource.getInputStream()));
    }


    @Override
    public void attachmentUploadSeaFile() {
        logger.info("attachmentUploadSeaFile上传开始============================>");
        //首先查询所有文件，seafileId查询数据库，查不到的可以直接删除
        //查到了为FileStatus.TEMP.getCode()的文件和数据库记录一起删除
        //查到了为FileStatus.SEAFILE只删除文件
        logger.info("上传路径====="+uploadDir);
        File fileUpload = new File(uploadDir);
        if(!(fileUpload.exists() && fileUpload.isDirectory())){
            fileUpload.mkdir();
        }
        File[] fileList = fileUpload.listFiles();
        logger.info("当前上传目录中文件数量为====="+fileList.length);
        for(File file : fileList) {
            System.out.println(file.getName());
            LambdaQueryWrapper<ReportAttachment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(ReportAttachment::getSeafileId, file.getName());
            ReportAttachment reportAttachment = reportAttachmentMapper.selectOne(lambdaQueryWrapper);
            if(reportAttachment == null){
                this.deleteFile(file);
            }else{
                if(reportAttachment.getFileStatus() == FileStatus.TEMP.getCode()){
                    reportAttachmentMapper.deleteById(reportAttachment.getAttachmentId());
                    this.deleteFile(file);
                }
                //暂时不上传seafile
                *//*if(reportAttachment.getFileStatus() == FileStatus.SERVER.getCode()){
                    iSeaFileService.uploadSeaFile(reportAttachment);
                    reportAttachment.setFileStatus(FileStatus.SEAFILE.getCode());
                    reportAttachmentMapper.updateById(reportAttachment);
                    this.deleteFile(file);
                }
                if(reportAttachment.getFileStatus() == FileStatus.SEAFILE.getCode()){
                    this.deleteFile(file);
                }*//*
            }
        }
        logger.info("attachmentUploadSeaFile上传结束============================>");
    }

    @Override
    public void attachmentDownloadClean() {
        logger.info("attachmentDownloadClean清理开始============================>");
        //获取下面的文件夹查询，查询不到数据库记录的直接删除清理
        // 若时间超过48小时的文件夹和zip一起删除
        logger.info("清理路径====="+downloadDir);
        // for(File file : new File(downloadDir).listFiles()){
        File fileDownload = new File(downloadDir);
        if(!(fileDownload.exists() && fileDownload.isDirectory())){
            fileDownload.mkdir();
        }
        File[] fileList = fileDownload.listFiles();
        logger.info("当前下载目录中文件数量为====="+fileList.length);

        for(File file : fileList){
            System.out.println(file.getName());

            LambdaQueryWrapper<ReportZip> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            if(file.getName().contains(Constant.ZIP_SUFFIX)){
                lambdaQueryWrapper.eq(ReportZip::getZipName,file.getName().replaceAll(Constant.ZIP_SUFFIX,""));
            }else{
                lambdaQueryWrapper.eq(ReportZip::getZipName,file.getName());
            }
            ReportZip reportZip = reportZipMapper.selectOne(lambdaQueryWrapper);
            if(reportZip == null){
                this.deleteFile(file);
            }else{
                if(Duration.between(reportZip.getGmtModified(), LocalDateTime.now()).toDays() > 2){
                    this.deleteFile(file);
                    reportZipMapper.deleteById(reportZip.getZipUuid());
                }
            }
        }
        logger.info("attachmentDownloadClean清理结束============================>");
    }


    private void deleteFile(File file){
        if(file.isDirectory()){
            try {
                FileUtils.deleteDirectory(file);
            } catch (IOException e) {
                e.printStackTrace();
                logger.info("不能删除此文件"+file.getAbsolutePath()+file.getName());
            }
        }else{
            file.delete();
        }
    }
}

*/
}