package com.dong.enums;

public enum REnum {

    //    SUCCESS(200, "成功"),
    UNKNOWN_ERROR(999, "信息发布服务端异常"),
    //LOGIN_FAIL(401, "登录失败, 登录信息失效或者为空"),//直接抛出返回的异常信息给前端
    //公文
    NO_UUID(101,"uuid为空"),
    ATTACHMENT_NO_ID(101,"附件id为空"),
    REPORT_NO_ID(101,"发文id为空"),
    REPORT_NO_UUID(102,"查询uuid为空"),
    TODO_NO_ID(101,"待办记录为空"),
    REPORT_NO_FAIL(103,"文号获取失败,请联系系统管理员查看"),
    REPORT_NO_RECORD(104,"未查询到公文记录"),
    REPORT_DELETE_NO_RECORD(105,"未查询到相应公文记录,删除失败"),
    REPORT_SUBMIT_FAIL(106,"提交失败"),
    REPORT_DRAFT_SUBMIT_FAIL(107,"草稿提交失败"),


    REPORT_SEND_DRAFT_SUBMIT_FAIL(106,"发文草稿修改后提交保存失败"),
    REPORT_INTERNAL_TODO_SUBMIT_FAIL(106,"内网信息提交发起待办失败"),
    REPORT_EXTERNAL_TODO_SUBMIT_FAIL(106,"外网信息提交发起待办失败"),


    REPORT_TYPE_ERROR(107,"公文类型错误"),
    REPORT_READ_REPEAT(108,"公文重复阅读统计"),
    REPORT_SEND_REPEAT(109,"公文重复发送"),
    READ_NO_RECORD(110,"阅读文件不存在"),
    RECEIVE_NO_RECORD(301,"未查询到收文记录"),
    RECEIVE_DRAFT_STATUS_ERROR(302,"文件不处于文件报送状态"),
    RECEIVE_REPORT_UPDATE_ERROR(303,"文件报送状态修改失败"),
    RECEIVE_DRAFT_TRANSFER_ERROR(304,"转收文不是子公司报送状态"),
    RECEIVE_DRAFT_UPDATE_ID(110,"文件报送更新表单id未传"),
    QUERY_DATA_NULL(111,"未查询到数据"),
    READ_NO_ID(101,"阅读记录id为空"),
    READ_NOT_FOUND(101,"未查询到阅读记录"),
    READ_EMPLOYEE_NULL(101,"未选择分发员工"),
    RECEIVE_REPORT_UPDATE_UNIQUE_FAIL(106,"文件报送更新和作者不是同一个人"),
    PROCESS_WITHDRAW_FAIL(101,"状态已被更新，不能撤回，请重新刷新表单"),
    SEND_REPORT_UPDATE_FAIL(110,"发文内容更新异常"),
    INTERNAL_REPORT_UPDATE_FAIL(110,"内网内容更新异常"),
    INTERNAL_REPORT_UPDATE_RECORD_FAIL(110,"内网内容更新记录异常"),
    EXTERNAL_REPORT_UPDATE_FAIL(110,"外网内容更新异常"),

    PROCESS_FINISH_FAIL(101,"状态已被更新，不能结束，请重新刷新表单"),
    RECEIVE_REPORT_UPDATE_FAIL(110,"收文内容更新异常"),
    PROCESS_BACK_FAIL(101,"状态已被更新，不能退回，请重新刷新表单"),
    REPORTNO_EXIST(111,"已存在发文号"),
    PROCESS_BACK_MAIN_FAIL(101,"主办不能退回"),

    PROCESS_BACK_MULTI_FAIL(101,"流程已分发给多人不能退回"),
    //参阅件
    REFER_NO_ID(401,"参阅件id为空"),

    REFER_SEND_REPEAT(402,"参阅件重复发送"),
    REFER_READ_REPEAT(403,"参阅件重复阅读统计"),
    REFER_NO_RECORD(404,"未查询到参阅件记录"),
    REFER_DISTRIBUTION_FAIL(106,"已分发的参阅件不允许更新"),

    REFER_DISTRIBUTION_RECORD(405,"参阅件已分发，不允许删除"),

    //内网信息
    INTERNAL_NO_ID(501,"内网信息id为空"),
    EXTERNAL_NO_ID(502,"外网信息id为空"),
    PORTAL_NO_ID(502,"门户信息id为空"),
    WEIXIN_NO_ID(503,"微信信息id为空"),

    //文件操作

    SEAFILE_QUERY_ERROR(701,"seafile文件查询错误"),
    SEAFILE_UPLOAD_ERROR(702,"seafile文件上传错误"),
    SEAFILE_DOWNLOAD_ERROR(703,"seafile文件下载错误"),
    REPORT_FILE_SERVER(711,"上传文件到本地服务器处理失败"),
    CREAT_FILE_SERVER_FAIL(711,"创建本地服务器下载目录失败"),
    REPORT_UPLOAD_REPEAT(712,"上传重复的文件"),
    ATTACHMENT_DELETE_EXIST(713,"删除文件不存在"),
    ATTACHMENT_UUID_NULL(714,"未传附件UUID"),
    FILE_NOT_EXISTS(715,"文件不存在"),
    ZIP_LINK_NOT_EXIST(716,"下载zip文件暂未生成"),
    NOT_DIRECTORY(781,"不是目录"),
    MAKE_DIR_ERROR(782,"创建文件夹异常"),
    ZIP_ERROR(783,"文件压缩错误"),
    FILE_TYPE_NOT_EXISTS(792,"文件类型不存在"),
    FILE_NAME_ERROR(793,"文件名错误"),
    FILE_UPLOAD_ERROR(794,"文件上传错误"),
    DOWNLOAD_FILE_FAIL(795,"下载文件失败"),
    FILE_URLENCODER_ERROR(796,"文件名URL编码错误"),
    FILE_DOWNLOAD_ERROR(797,"附件下载服务错误"),
    FILE_NO_ATTACHMENT(798,"下载附件不存在"),
    FILE_NO_ZIP(798,"下载zip文件不存在"),
    FILE_DOWNLOAD_ZIP_ERROR(797,"zip文件下载服务错误"),
    FILE_NO_ZIP_EXIST(798,"下载zip文件还未生成"),
    REPORT_DELETE_EXIST(713,"删除文件不存在"),

    //流程枚举
    PROCESS_NODE_FAIL(814,"根据nodeCode查询未获取到节点信息"),
    PROCESS_NODECODE_NULL(101,"节点信息为空"),
    PROCESS_TODOID_NULL(101,"待办任务id为空"),
    PROCESS_REPORTTODO_FAIL(101,"未查到待办任务"),
    PROCESS_TODO_FAIL(101,"状态已被更新，不能发起流程，请重新刷新表单"),
    PROCESS_MAIN_FAIL(101,"主办中副部长指给部长不允许多人"),
    WORKFLOW_REQUEST_FAIL(801,"工作流服务访问错误"),
    WORKFLOW_REQUEST_DATA_FAIL(801,"工作流服务访问数据解析错误"),
    PROCESS_RECEIVE_ASSIGNEE_ERROR(811,"收文流程发起处理人不唯一"),
    PROCESS_TYPE_ERROR(812,"流程返回处理方式不符合要求，请检查传入参数"),
    PROCESS_DATA_ERROR(813,"流程返回数据解析错误"),
    PROCESS_NUM_ERROR(813,"指定办理人非唯一"),
    PROCESS_EXECUTE_ERROR(814,"发起流程执行失败"),
    PROCESS_COMPLETE_ERROR(815,"加签节点完成任务执行失败"),
    PROCESS_EXECUTEANDJUMP_ERROR(816,"任务退回（驳回）执行失败"),
    PROCESS_WITHDRAW_ERROR(817,"任务撤回执行失败"),
    PROCESS_TASK_ERROR(818,"待办任务找不到对应的业务数据"),

    SUBMIT_PROCESS_NODE_FAIL(821,"提交流程节点维护人失败"),

    UPDATE_NODE_EMPLOYEE_FAIL(821,"更新流程节点维护人失败"),
    ADD_NODE_EMPLOYEE_FAIL(821,"新增流程节点维护人失败"),
    EXIST_NODE_EMPLOYEE(821,"流程节点已经存在此人，请重新选择"),
    NOT_EXIST_NODE_EMPLOYEE(821,"流程节点删除员工不存在"),
    DELETE_NODE_EMPLOYEE_UNIQUE_FAIL(821,"流程节点不允许删除最后一个维护人，请先添加一个维护人再删除，保证至少有一个维护人"),
    DELETE_NODE_EMPLOYEE_FAIL(821,"流程节点删除维护失败"),


    EXIST_CHILD_EMPLOYEE(821,"已经存在此人，请重新选择"),
    NOT_EXIST_CHILD_EMPLOYEE(821,"删除员工不存在"),

    //SSO枚举
    SSO_SERVICE_FAIL(901,"[SSO]服务访问失败"),
    SSO_PARSE_DATA_FAIL(902,"[SSO]服务数据解析错误"),
    SSO_AUTHORIZATION_FAIL(905,"用户Authorization认证失败，请重新登陆获取"),
    SSO_REQUEST_ROLE_FAIL(903,"用户没有访问此接口权限"),
    SSO_LOGINUSER_FAIL(904,"获取登陆用户信息失败");

    private Integer code;
    private String desc;

    REnum(Integer code, String desc) {
        this.code = 51000 + code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 通过枚举code获得枚举。
     * @param code  简码
     * @return      枚举
     */
    public static REnum getByCode(Integer code) {
        for (REnum rEnum : values()) {
            if (rEnum.getCode()==code) {
                return rEnum;
            }
        }
        return null;
    }

}

