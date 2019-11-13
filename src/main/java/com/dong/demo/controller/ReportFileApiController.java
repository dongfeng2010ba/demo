package com.dong.demo.controller;

import com.common.utils.R;
import com.common.utils.Tip;
import com.dong.annotation.User;
import com.dong.demo.entity.ReportAttachment;
import com.dong.demo.entity.ReportZip;
import com.dong.demo.service.IReportFileService;
import com.dong.demo.vo.*;
import com.dong.enums.REnum;
import com.dong.exception.RException;
import com.dong.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Api(description = "公文管理文件服务api")
@RestController
@RequestMapping("/api/file")
public class ReportFileApiController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IReportFileService iReportFileService;

   /* @ApiOperation(value="单文件上传")
    @PostMapping("/upload")
    public R<ReportAttachment> uploadAttachment(ReportAttachmentV reportAttachmentV, @RequestParam MultipartFile file){
        //todo 验证必须有uuid和type，没有直接给提示ValidatorUtils、
        ValidatorUtils.validateEntity(reportAttachmentV);
      //  return R.ok(iReportFileService.uploadAttachment(reportAttachmentV,file));
        return R.ok();
    }

    @ApiOperation(value="多文件上传")
    @PostMapping("/upload/multi")
    public R<List<ReportAttachment>> uploadMultiAttachment(ReportAttachmentV reportAttachmentV, @RequestParam MultipartFile[] files){
        //todo 验证必须有uuid和type，没有直接给提示ValidatorUtils、
        ValidatorUtils.validateEntity(reportAttachmentV);
        List<ReportAttachment> reportAttachmentList = new ArrayList<>();
        for(MultipartFile file : files){
           // reportAttachmentList.add(iReportFileService.uploadAttachment(reportAttachmentV,file));
        }
        return R.ok(reportAttachmentList);
    }


    @ApiOperation(value="删除单文件")
    @GetMapping("/delete/{attachmentId}")
    public R<List<ReportAttachment>> deleteFile(@PathVariable(value = "attachmentId") String attachmentId){
        if(StringUtils.isEmpty(attachmentId)){throw new RException(REnum.ATTACHMENT_NO_ID);}
        return R.ok(iReportFileService.deleteAttachment(attachmentId));
    }

    @ApiOperation(value="单文件下载")
    @GetMapping("/download/{attachmentId}")
    public ResponseEntity<InputStreamResource> downloadAttachment(@PathVariable(value = "attachmentId") String attachmentId, HttpServletResponse response) {
        if(StringUtils.isEmpty(attachmentId)){throw new RException(REnum.ATTACHMENT_NO_ID);}
        return iReportFileService.downloadAttachment(attachmentId,response);
    }

    @ApiOperation(value="单文件下载获取下载链接")
    @GetMapping("/download/link/{attachmentId}")
    public R<ReportAttachment> downloadLinkAttachment(@PathVariable(value = "attachmentId") String attachmentId) {
        if(StringUtils.isEmpty(attachmentId)){throw new RException(REnum.ATTACHMENT_NO_ID);}
        return R.ok(iReportFileService.downloadLinkAttachment(attachmentId));
    }

    @ApiOperation(value="多条公文选择类型下载(大文件)")
    @PostMapping("/package/zip")
    public R packageZip(@RequestBody ReportZipPV reportZipPV, @User LoginUser loginUser) {
        iReportFileService.packageZip(reportZipPV,loginUser);
        return R.okMsg(Tip.ZIP_GENERATE);
    }

    @ApiOperation(value="我的下载(大文件)")
    @PostMapping("/mine/download")
    public R<PageRV<ReportZip>> mineDownload(@RequestBody PageV pageV, @User LoginUser loginUser) {
        return R.ok(iReportFileService.mineDownload(pageV,loginUser));
    }

    @ApiOperation(value="我的下载(大文件)zip下载")
    @GetMapping("/download/zip/{zipUuid}")
    public ResponseEntity<InputStreamResource> downloadZip(@PathVariable(value = "zipUuid") String zipUuid, HttpServletResponse response) {
        if(StringUtils.isEmpty(zipUuid)){throw new RException(REnum.ATTACHMENT_NO_ID);}
        return iReportFileService.downloadZip(zipUuid,response);
    }
*/
}