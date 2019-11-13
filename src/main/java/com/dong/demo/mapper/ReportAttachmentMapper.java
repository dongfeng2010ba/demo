package com.dong.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dong.demo.entity.ReportAttachment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
//public interface ReportAttachmentMapper extends BaseMapper<ReportAttachment> {
public interface ReportAttachmentMapper {
   /* @Select("SELECT max(attachment_serial) FROM cp_report_attachment where attachment_uuid = #{attachmentUuid}")
    Integer maxAttachmentSerial(@Param("attachmentUuid")String attachmentUuid);

    @Update("UPDATE cp_report_attachment SET file_status = #{fileStatus} WHERE attachment_uuid = #{attachmentUuid} ")
    Integer updateFileStatus(@Param("attachmentUuid")String attachmentUuid,@Param("fileStatus")Integer fileStatus);
*/}
