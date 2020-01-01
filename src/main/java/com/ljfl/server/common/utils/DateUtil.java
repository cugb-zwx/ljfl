package com.ljfl.server.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 11:33
 */
public class DateUtil {
    /**
     * 1 代表 -
     * 2 代表 汉字
     * 3 代表 /
     * 4 代表 :
     * _ 代表 空格
     */
    private static final String yyyy1MM1dd = "yyyy-MM-dd";
    private static final String yyyy2MM2dd = "yyyy年 MM月 DD日";
    private static final String yyyy1MM1dd_HH4mm = "yyyy-MM-dd HH:mm";
    private static final String yyyy2MM2dd_HH2mm = "yyyy年 MM月 dd日 HH时 mm分";

    private static final int ms_day = 1000 * 3600 * 24;

    /**
     * 存放不同的日期模板格式的sdf的Map
     */
    private static ThreadLocal<Map<String, SimpleDateFormat>> threadLocal_sdfMap = new ThreadLocal<>();

    private static SimpleDateFormat getSdf(final String pattern) {
        Map<String, SimpleDateFormat> sdfMap = threadLocal_sdfMap.get();
        if (sdfMap == null) {
            sdfMap = new HashMap<>();
            threadLocal_sdfMap.set(sdfMap);
        }
        SimpleDateFormat tl = sdfMap.get(pattern);
        if (tl == null) {
            tl = new SimpleDateFormat(pattern);
            sdfMap.put(pattern, tl);
        }
        return tl;
    }

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
     *
     * @param date
     * @return
     */
    public static Long dateToLong(Date date) {
        if (date != null) return date.getTime();
        return null;
    }

    /**
     * Str时间转Date日期
     *
     * @param time
     * @return
     */
    public static Date strToDate(String time) {
        return strToDate(time, yyyy1MM1dd);
    }

    /**
     * Str时间转Date日期
     *
     * @param time
     * @param fmtStr
     * @return
     */
    public static Date strToDate(String time, String fmtStr) {
        if (StringUtils.isBlank(time)) return null;
        SimpleDateFormat fmt = getSdf(fmtStr);
        try {
            return fmt.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Date时间转Str日期
     *
     * @param date
     * @return
     */
    public static String dateToStr(Date date) {
        return dateToStr(date, yyyy1MM1dd);
    }

    /**
     * Date时间转Str日期
     *
     * @param date
     * @param fmtStr
     * @return
     */
    public static String dateToStr(Date date, String fmtStr) {
        if (date == null) return null;
        SimpleDateFormat fmt = getSdf(fmtStr);
        return fmt.format(date);
    }

    /**
     * Long时间转Str日期
     *
     * @param time
     * @return
     */
    public static String longToStr(Long time) {
        return longToStr(time, yyyy1MM1dd);
    }

    /**
     * Long时间转Str日期
     *
     * @param time
     * @param fmtStr
     * @return
     */
    public static String longToStr(Long time, String fmtStr) {
        if (time == null) return null;
        SimpleDateFormat fmt = getSdf(fmtStr);
        return fmt.format(longToDate(time));
    }

    /**
     * Str时间转Date日期
     *
     * @param time
     * @return
     */
    public static Long strToLong(String time) {
        if(StringUtils.isBlank(time)) return null;
        return strToDate(time, yyyy1MM1dd).getTime();
    }

    /**
     * 获取long时间days天之前的long时间
     * @param time
     * @param days
     * @return
     */
    public static Long getTimeBefore(Long time, Integer days) {
        if (time == null)
            return null;
        return getDateBefore(longToDate(time), days).getTime();
    }

    /**
     * 获取date时间days天之前的date时间
     * @param date
     * @param days
     * @return
     */
    public static Date getDateBefore(Date date, Integer days) {
        if (date == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - days);
        return c.getTime();
    }

    /**
     * 获取long时间days天之后的long时间
     * @param time
     * @param days
     * @return
     */
    public static Long geTimeAfter(Long time,Integer days) {
        if (time == null) {
            return null;
        }
        return getDaysAfter(new Date(time),days).getTime();
    }

    /**
     * 获取date时间days天之后的date时间
     * @param date
     * @param days
     * @return
     */
    public static Date getDaysAfter(Date date,Integer days) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + days);
        return c.getTime();
    }

    /**
     * 获取long时间直接的long时间间隔
     * @param start
     * @param end
     * @return
     */
    public static Long getTimeBetween(Long start, Long end) {
        if (start == null || end == null) {
            return Long.valueOf(-1);
        }
        return ceilDay(end - start);
    }

    /**
     * 获取date时间直接的long时间间隔
     * @param start
     * @param end
     * @return
     */
    public static Long getTimeBetween(Date start, Date end) {
        if (start == null || end == null) {
            return Long.valueOf(-1);
        }
        return getTimeBetween(start.getTime(), end.getTime());
    }

    //向上取整
    private static Long ceilDay(Long value) {
        Long count = value / ms_day;
        Long extra = value % ms_day;
        return extra == 0 ? count : count + 1;
    }

    //向下取整
    public static Long floorDay(Long value) {
        return value / ms_day;
    }

}
