package com.ljfl.server.vo;

/**
 * 返回值信息，通常是返回成功，或者异常信息
 *
 * @author niexiao
 * @created 2018/10/15
 */
public class ResponseMsg {
    private Integer code;
    private String type;
    private String message;

    public ResponseMsg() {
    }

    public ResponseMsg(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}