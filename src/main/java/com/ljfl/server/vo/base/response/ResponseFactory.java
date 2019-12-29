package com.ljfl.server.vo.base.response;

/**
 * api返回结果的工厂类
 *
 * @author zwx
 * @created 2019/12/29
 */
public class ResponseFactory {

    public static final Response buildSuccess() {
        return new SuccessResponse();
    }

    public static final Response buildSuccess(String msg) {
        return new SuccessResponse(msg);
    }

    public static final Response buildSuccess(Object data) {
        return new SuccessResponse(data);
    }

    public static final Response buildSuccess(String msg, Object data) {
        return new SuccessResponse(msg, data);
    }

    public static final Response buildFailure() {
        return new FailResponse();
    }

    public static final Response buildFailure(String message) {
        return new FailResponse(message);
    }


    public static final FailResponse buildFailure(Object data) {
        return new FailResponse(data);
    }

    public static final FailResponse buildFailure(String msg, Object data) {
        return new FailResponse(msg, data);
    }

}