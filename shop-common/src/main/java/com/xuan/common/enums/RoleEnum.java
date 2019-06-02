package com.xuan.common.enums;

public enum RoleEnum {

    SYS(1, "系统管理员"),
    NORMAL(2, "普通用户"),
    MERCHANT(3, "商户");

    private Integer type;
    private String name;

    RoleEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
