package com.ljfl.server.common.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2020/1/9 22:57
 */
public class LoggerUtil {
    private static final String logBefore = "前置信息-------->>>>>>>>{}调用{}方法,参数:{}";
    private static final String logAftter = "后置信息--------<<<<<<<<{}调用{}方法,参数:{}，结果:{}";
    private static final String logError = "错误信息========》{}调用{}方法,参数:{},异常信息:{}";

    public static void logBefore(Logger logger, String methdName, Object... params) {
        logger.error(logBefore, logger.getName(), methdName, JSON.toJSONString(params));
    }

    public static void logAftter(Logger logger, String methdName, String result, Object... params) {
        logger.error(logAftter, logger.getName(), methdName, JSON.toJSONString(params), result);
    }

    public static void logAftter(Logger logger, String methdName, Object... params) {
        logAftter(logger, methdName, "无返回结果", params);
    }

    public static void logError(Logger logger, String methdName, String eMsg, Object... params) {
        logger.error(logError, logger.getName(), methdName, JSON.toJSONString(params), eMsg);
    }

    public static void logError(Logger logger, String methdName, Exception e, Object... params) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        e.printStackTrace(new PrintWriter(charArrayWriter));
        logger.error(logError, logger.getName(), methdName, JSON.toJSONString(params), charArrayWriter.toString());
    }
}
