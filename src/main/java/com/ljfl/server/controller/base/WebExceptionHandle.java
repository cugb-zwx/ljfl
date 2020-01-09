package com.ljfl.server.controller.base;

import com.ljfl.server.common.constants.ExceptionConstant;
import com.ljfl.server.common.exceptions.CustomException;
import com.ljfl.server.common.utils.LoggerUtil;
import com.ljfl.server.vo.base.response.Response;
import com.ljfl.server.vo.base.response.ResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2020/1/9 22:54
 */
@ControllerAdvice
@ResponseBody
public class WebExceptionHandle {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        LoggerUtil.logError(logger, "handleHttpMessageNotReadableException", e);
        return ResponseFactory.buildFailure(ExceptionConstant.params_error);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        LoggerUtil.logError(logger, "handleHttpRequestMethodNotSupportedException", e);
        return ResponseFactory.buildFailure(ExceptionConstant.method_error);
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response handleHttpMediaTypeNotSupportedException(Exception e) {
        LoggerUtil.logError(logger, "handleHttpMediaTypeNotSupportedException", e.getMessage());
        return ResponseFactory.buildFailure(ExceptionConstant.media_error);
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        LoggerUtil.logError(logger, "handleException", e);
        return ResponseFactory.buildFailure(ExceptionConstant.inner_error);
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(CustomException.class)
    public Response handleCustomException(CustomException e) {
        LoggerUtil.logError(logger, "handleCustomException", e);
        return ResponseFactory.buildFailure(e.getMessage());
    }
}
