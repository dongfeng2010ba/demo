package com.dong.enums;

public enum ZipStatus {

    INIT(0,"生成中"),

    EXIST(1,"已生成");

    /** 简码 */
    private final Integer code;
    /** 描述 */
    private final String desc;

    /**
     * 私有构造方法
     * @param code   简码
     * @param desc   描述
     */
    private ZipStatus(Integer code, String desc) {
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
    public static ZipStatus getByCode(Integer code) {
        for (ZipStatus reportPriority : values()) {
            if (reportPriority.getCode()==code) {
                return reportPriority;
            }
        }
        return null;
    }

}

