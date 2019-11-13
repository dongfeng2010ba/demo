package com.dong.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.utils.Constant;
import com.common.utils.ZipUtils;
import com.dong.demo.entity.ReportAttachment;
import com.dong.demo.entity.ReportZip;
import com.dong.demo.mapper.ReportAttachmentMapper;
import com.dong.demo.mapper.ReportZipMapper;
import com.dong.demo.service.IReportZipService;
import com.dong.demo.service.ISeaFileService;
import com.dong.demo.vo.ReportZipPV;
import com.dong.demo.vo.SeaFileInfoV;
import com.dong.enums.FileStatus;
import com.dong.enums.REnum;
import com.dong.enums.ZipStatus;
import com.dong.exception.RException;
import com.dong.properties.SSOProperties;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipFile;

@Service
public class ReportZipServiceImpl implements IReportZipService {

    private final Logger logger = LoggerFactory.getLogger(ReportZipServiceImpl.class);

   /* @Autowired
    private SSOProperties reportFileProperties;
*/
  /*  @Autowired
    private ReportAttachmentMapper reportAttachmentMapper;*/

    /*@Autowired
    private ReportZipMapper reportZipMapper;*/

  /*  @Autowired
    private ISeaFileService iSeaFileService;*/



   /* @Autowired
    private ReportInternalMapper reportInternalMapper;

    @Autowired
    private ReportExternalMapper reportExternalMapper;
*/
    /**
     * 服务器端文件下载目录
     */
    @Value(value = "${reportfile.downloadDir}")
    private String downloadDir;

/*

    @Override
    @Async
    public void asyncBatchDownLoadAndCreateZipFile(ReportZipPV reportZipPV, ReportZip reportZip){
*/
/*//*
/        String rootPath = downloadDir + reportZip.getZipName() + File.separator;
        String rootPath = downloadDir + reportZip.getZipName() + "/";
        try {
            //1.创建根文件夹和子文件夹
            if (!Files.exists(Paths.get(rootPath))) {
                Files.createDirectories(Paths.get(rootPath));
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("创建下载服务器本地目录失败");
            throw new RException(REnum.CREAT_FILE_SERVER_FAIL);
        }


        if(reportZipPV.getInfoType() == InfoType.INTERNAL.getCode()){
            for(ReportInternal reportInternal : reportInternalMapper.selectBatchIds(reportZipPV.getReportIds())){
                singleDownLoad(rootPath + reportInternal.getReportTitle(),reportInternal.getAttachmentUuid(),reportZipPV.getAttachmentTypes());
            }
        }
        if(reportZipPV.getInfoType() == InfoType.EXTERNAL.getCode()){
            for(ReportExternal reportExternal : reportExternalMapper.selectBatchIds(reportZipPV.getReportIds())){
                singleDownLoad(rootPath + reportExternal.getReportTitle(),reportExternal.getAttachmentUuid(),reportZipPV.getAttachmentTypes());
            }
        }

        //压缩根目录
        ZipFile zipFile = ZipUtils.createZipFile(rootPath, reportZip.getZipName()+ Constant.ZIP_SUFFIX);
        reportZip.setZipStatus(ZipStatus.EXIST.getCode());*//*

        reportZip.setZipDesc(ZipStatus.EXIST.getDesc());
        reportZipMapper.updateById(reportZip);
    }



    @Override
    @Transactional
    public String batchDownLoadAndCreateZipFile(ReportZipPV reportZipPV,String zipName) {
        String rootPath = downloadDir + zipName + File.separator;
        try {
            //1.创建根文件夹和子文件夹
            if (!Files.exists(Paths.get(rootPath))) {
                Files.createDirectories(Paths.get(rootPath));
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("创建下载服务器本地目录失败");
            throw new RException(REnum.CREAT_FILE_SERVER_FAIL);
        }


     */
/*   if(reportZipPV.getInfoType() == InfoType.INTERNAL.getCode()){
            for(ReportInternal reportInternal : reportInternalMapper.selectBatchIds(reportZipPV.getReportIds())){
                singleDownLoad(rootPath + reportInternal.getReportTitle(),reportInternal.getAttachmentUuid(),reportZipPV.getAttachmentTypes());
            }
        }
        if(reportZipPV.getInfoType() == InfoType.EXTERNAL.getCode()){
            for(ReportExternal reportExternal : reportExternalMapper.selectBatchIds(reportZipPV.getReportIds())){
                singleDownLoad(rootPath + reportExternal.getReportTitle(),reportExternal.getAttachmentUuid(),reportZipPV.getAttachmentTypes());
            }
        }

        //压缩根目录
        ZipFile zipFile = ZipUtils.createZipFile(rootPath, zipName+ Constant.ZIP_SUFFIX);*//*

        return rootPath + Constant.ZIP_SUFFIX;
    }

    private void singleDownLoad(String reportPath, String attachmentUuid, List<Integer> attachmentTypes) {
        for (Integer attachmentType : attachmentTypes) {
            LambdaQueryWrapper<ReportAttachment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(ReportAttachment::getAttachmentUuid,attachmentUuid);
            lambdaQueryWrapper.eq(ReportAttachment::getAttachmentType,attachmentType);
            for(ReportAttachment reportAttachment : reportAttachmentMapper.selectList(lambdaQueryWrapper)){
//                String childDirPath = reportPath + File.separator + AttachmentType.getByCode(reportAttachment.getAttachmentType()).getDesc() + File.separator ;
              //  String childDirPath = reportPath + "/" + AttachmentType.getByCode(reportAttachment.getAttachmentType()).getDesc() + "/" ;
                try {
              */
/*      if (!Files.exists(Paths.get(childDirPath))) {
                        Files.createDirectories(Paths.get(childDirPath))

                        };*//*

                System.out.println("ss");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.info("创建下载服务器本地下载类型失败");
                    throw new RException(REnum.REPORT_FILE_SERVER);
                }
                //在seafile上则直接下载到服务端
                if(reportAttachment.getFileStatus()== FileStatus.SEAFILE.getCode()) {
                    SeaFileInfoV seaFileInfoV = iSeaFileService.getSeaFile(reportAttachment);
                    iSeaFileService.downLoadSeaFile(seaFileInfoV.getDownloadUrl(),reportAttachment);
                }
                File uploadFile = Paths.get(reportAttachment.filePath()).toFile();
            */
/*    File zipFile = Paths.get(childDirPath + reportAttachment.getFileOriginName()).toFile();
                try {
                    FileUtils.copyFile(uploadFile,zipFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                uploadFile.renameTo(zipFile);*//*

            }
        }
    }


*/
}