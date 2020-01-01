package com.ljfl.server.common.exceptions;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 23:47
 */
public class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg);
    }
}
