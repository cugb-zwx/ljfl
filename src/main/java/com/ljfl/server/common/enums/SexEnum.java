package com.ljfl.server.common.enums;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2020/1/16 23:04
 */
public enum SexEnum {
    female(0, "女"), male(1, "男");

    SexEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
