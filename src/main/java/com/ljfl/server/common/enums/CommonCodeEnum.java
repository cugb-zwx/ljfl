package com.ljfl.server.common.enums;

/**
 * 公共返回码
 *
 * @author niexiao
 * @created 2018/10/15
 */
public enum CommonCodeEnum {

    SUCCESS(100000, "COMMON_SUC", "请求成功"),
    INTERNAL_ERROR(100001, "COMMON_INTERNAL_ERROR", "内部异常"),
    PARAMS_ILLEGAL_ERROR(100002, "COMMON_PARAMS_ILLEGAL", "参数错误"),
    HTTP_ERROR(100003, "COMMON_HTTP_ERROR", "HTTP调用异常"),
    FILE_NOT_EXIST(100004, "FILE_NOT_EXIST", "文件不存在"),
    ;

    CommonCodeEnum(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    private final Integer code;
    private final String type;
    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}