package com.ljfl.server.vo.base.response;

import com.ljfl.server.vo.base.BaseObject;

/**
 * 通用的返回值对象
 *
 * @author zwx
 * @created 2019/12/29
 */

public abstract class Response extends BaseObject {

    private static final long serialVersionUID = 2805648192420441468L;

    protected static final Byte success_code = 1;
    protected static final String success_msg = "请求成功";
    protected static final Byte fail_code = 0;
    protected static final String fail_msg = "请求失败";

    private Byte code;
    private String msg;
    private Object data;

    public Response(Byte code) {
        this.code = code;
        if (isSuccess()) {
            this.msg = success_msg;
        } else {
            this.msg = fail_msg;
        }
    }

    public Response(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Byte code, Object data) {
        this.code = code;
        if (isSuccess()) {
            this.msg = success_msg;
        } else {
            this.msg = fail_msg;
        }
        this.data = data;
    }

    public Response(Byte code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private boolean isSuccess() {
        return success_code.equals(code);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}