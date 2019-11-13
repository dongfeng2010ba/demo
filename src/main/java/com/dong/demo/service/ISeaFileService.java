package com.dong.demo.service;

import com.dong.demo.entity.ReportAttachment;
import com.dong.demo.vo.SeaFileInfoV;
import com.dong.demo.vo.SeaFileUploadResultV;

public interface ISeaFileService {

    /**
     * @Description 单文件上传
     * @Param reportAttachment 附件信息
     * @Return SeaFileUploadResultV 上传文件后返回的信息
     */
    SeaFileUploadResultV uploadSeaFile(ReportAttachment reportAttachment);

    /**
     * @Description     根据文件编号或者文件批号查询文件链接
     * @Param dict      文件批号
     * @Param dictItem  文件id
     */
    SeaFileInfoV getSeaFile(ReportAttachment reportAttachment);

    /**
     * 单文件下载到指定路径下
     * @param downloadUrl       文件下载链接
     * @param reportAttachment   附件信息
     * @return
     */
    void downLoadSeaFile(String downloadUrl, ReportAttachment reportAttachment);

}

