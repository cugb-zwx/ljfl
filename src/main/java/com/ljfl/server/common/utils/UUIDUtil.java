package com.ljfl.server.common.utils;

import java.util.UUID;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2020/1/1 18:43
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().substring(0, 20);
    }
}
