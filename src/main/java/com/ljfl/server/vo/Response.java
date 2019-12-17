package com.ljfl.server.vo;

/**
 * 通用的返回值对象
 *
 * @author niexiao
 * @created 2018/10/16
 */
public class Response<T> extends BaseObject {
    private T data;

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}