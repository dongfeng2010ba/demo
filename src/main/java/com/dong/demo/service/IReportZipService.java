package com.dong.demo.service;

import com.dong.demo.entity.ReportZip;
import com.dong.demo.vo.ReportZipPV;

public interface IReportZipService {
/*
    *//**
     *  异步批量下载压缩
     * @param reportZipPV  选择的附件信息
     *//*
    void asyncBatchDownLoadAndCreateZipFile(ReportZipPV reportZipPV, ReportZip reportZip);

    *//**
     *  同步批量下载压缩
     * @param reportZipPV  选择的附件信息
     * @return 压缩文件的路径
     *//*
    String batchDownLoadAndCreateZipFile(ReportZipPV reportZipPV, String zipName);*/
}

