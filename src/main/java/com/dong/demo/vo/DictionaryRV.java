package com.dong.demo.vo;

import com.sun.xml.internal.ws.api.server.WebModule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 公文管理所有的公文
 * </p>
 *
 * @author xm.yi
 * @since 2019-07-18
 */
@Data
@ApiModel
public class DictionaryRV implements Serializable {

    private static final long serialVersionUID = 1L;

  /*  @ApiModelProperty("发文数据字典")
    public List<ReportTypeV> reportSendTypes = new ArrayList<ReportTypeV>();

    @ApiModelProperty("收文数据字典")
    public List<ReportTypeV> reportReceiveTypes = new ArrayList<ReportTypeV>();

    @ApiModelProperty("缓急（特指机要文件缓急）")
    public List<ReportWeight> reportWeights = new ArrayList<ReportWeight>();

    @ApiModelProperty("网站板块")
    public List<WebModule> webModules = new ArrayList<>();


    @ApiModelProperty("todo查询状态")
    List<ReportStatusV>  reportStatusVList = new ArrayList<>();

    @ApiModelProperty("todo查询状态")
    List<TodoStatusV>  todoStatusVList = new ArrayList<>();

    @ApiModelProperty("公文紧急程度")
    List<ReportPriorityV> reportPrioritys = new ArrayList<ReportPriorityV>();

    @ApiModelProperty("提醒方式")
    List<RemindWayV> remindWays = new ArrayList<RemindWayV>();

    @ApiModelProperty("发文附件类型")
    List<SendType> sendTypes = new ArrayList<SendType>();

    @ApiModelProperty("收文附件类型")
    List<ReceiveType> receiveTypes = new ArrayList<ReceiveType>();

    @ApiModelProperty("参阅件附件类型")
    List<ReferType> referTypes = new ArrayList<ReferType>();*/


}

