package com.dong.enums;

public enum FileStatus {
    TEMP(0,"临时"),

    SERVER(1,"服务器"),

    SEAFILE(2,"seafile");

    /** 简码 */
    private final Integer code;
    /** 描述 */
    private final String desc;

    /**
     * 私有构造方法
     * @param code   简码
     * @param desc   描述
     */
    FileStatus(Integer code, String desc) {
        this.code = code;
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
    public static FileStatus getByCode(Integer code) {
        for (FileStatus fileStatus : values()) {
            if (fileStatus.getCode()==code) {
                return fileStatus;
            }
        }
        return null;
    }
}

