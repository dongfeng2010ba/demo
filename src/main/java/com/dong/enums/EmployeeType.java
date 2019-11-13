package com.dong.enums;

public enum EmployeeType {

    SYS_EMPLOYEE(0,"系统维护流程人员"),

    MINISTER(1, "部门领导"),         //desc不能修改，需要获取职位对应人员

    VICE_MINISTER(2, "副部门领导"),  //desc不能修改，需要获取职位对应人员

    EMPLOYEE(3, "普通员工"),         //desc不能修改，需要获取职位对应人员

    LEADER(4,"领导"),

    ALL(5,"部门全部人员"),

    VICE_MINISTER_EMPLOYEE(6,"部门副领导+普通员工"),

    AUTHOR_CHECK(9,"拟稿人校对(发文)");

    /** 简码 */
    private final Integer code;
    /** 描述 */
    private final String desc;

    /**
     * 私有构造方法
     * @param code   简码
     * @param desc   描述
     */
    private EmployeeType(Integer code, String desc) {
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
    public static EmployeeType getByCode(Integer code) {
        for (EmployeeType employeeType : values()) {
            if (employeeType.getCode()==code) {
                return employeeType;
            }
        }
        return null;
    }
}
