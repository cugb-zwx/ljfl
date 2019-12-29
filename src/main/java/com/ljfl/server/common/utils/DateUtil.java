package com.ljfl.server.common.utils;

import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 11:33
 */
public class DateUtil {
    /**
     * Long时间转Date日期
     *
     * @param time
     * @return
     */
    public static Date longToDate(Long time) {
        if (time != null) return new Date(time);
        return null;
    }

    /**
     * Date日期转Long时间
     * @param date
     * @return
     */
    public static Long dateToLong(Date date) {
        if (date != null) return date.getTime();
        return null;
    }
}
