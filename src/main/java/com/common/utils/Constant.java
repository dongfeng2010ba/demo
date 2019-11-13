package com.common.utils;

public class Constant {

/***数值常量************************************************************************************************************/
    /**  系統停用 */
    public static final Integer DICT_DISABLE = 0;
    /**  系統启用 */
    public static final Integer DICT_USED = 1;
    /**  数据字典层级1 */
    public static final Integer DICT_LEVEL_ONE = 1;
    /**  数据字典层级2 */
    public static final Integer DICT_LEVEL_TWO = 2;
    /**  一次性生成多少代字号 */
    public static final Integer PROXY_NUM = 20;
    /**  一次性生成多少字号 */
    public static final Integer NUM = 20;

    /**  首页的最新发文和收文展示数量 */
    public static final Long NEWS_NUM = 5L;

/****字符串常量************************************************************************************************************/
    /**  公文管理系統code */
    public static final String SSO_SYS_CODE = "gwgl";
    /**  系統id */
    public static final String SYS_ID = "cp_report";
    /**  网站板块 */
    public static final String WEB_MODULE = "web_module";
    /**  缓急（特指机要文件缓急） */
    public static final String REPORT_WEIGHT = "report_weight";
    /**  发文类型 */
    public static final String REPORT_SEND_TYPE = "report_send_type";
    /**  收文类型 */
    public static final String REPORT_RECEIVE_TYPE = "report_receive_type";

    /** 子公司 */
    public static final String CHILD_COMPANY = "child_company";
    /** 子公司 */
    public static final String CHILD_COMPANY_NAME = "子公司";
    /**  集团文书+子公司文书 */
    public static final String[] JWS_ZWS = {"jws","zws"};

    /**  集团文书 */
    public static final String[] JWS = {"jws"};

    /**  子公司文书 */
    public static final String[] ZWS = {"zws"};




    /**  发文处理状态 */
    //public static final String REPORT_SEND_STATUS = "report_send_status";
    /**  收文处理状态 */
    //public static final String REPORT_RECEIVE_STATUS = "report_receive_status";
    /**  zip文件后缀*/
    public static final String ZIP_SUFFIX = ".zip";

    /**  流程引擎收文流程定义名称*/
    public static final String RECEIVE_PROCESS_NAME = "znsjRecv";
    /**  流程引擎收文流程定义发送办公室拟办*/
    public static final String RECEIVE_TASK_KEY_FIRST = "znsjRecv_officeAssistant";
    public static final String RECEIVE_ASSIGNEE_KEY_FIRST = "officeAssistant";
    /**  流程引擎收文流程定义名称*/
    public static final String SEND_PROCESS_NAME = "znsjSend";
    /**  流程引擎收文流程定义发送办公室拟办*/
    public static final String SEND_TASK_KEY_FIRST = "znsjSend_apply";


    /**     内网拟稿人 */
    public static final String INTERNAL_AUTHOR = "internal_author";

    /**     门户拟稿人 */
    public static final String PORTAL_AUTHOR = "portal_author";

    /**     微信拟稿人 */
    public static final String WEIXIN_AUTHOR = "weixin_author";

    /**  预览文件根路径 */
    public static final String FILE_PATH = "/file/";

    /**  短信模板code */
    public static final String SMS_175573174 = "SMS_175573174";

}
