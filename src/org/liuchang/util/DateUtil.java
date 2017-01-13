package org.liuchang.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 获取时间相关内容工具
 * Created by liuchang on 2016/4/7.
 */
public class DateUtil {

    /**
     * 当月第一天
     */
    public final static int FIRST_DAY_OF_MONTH = 1;
    /**
     * 今天
     */
    public final static int TODAY = 0;

    /**
     * 日期格式化 yyyy-MM-dd
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDateAsString(int day) {
        Calendar cal = Calendar.getInstance();
        String dateStr;
        switch (day) {
            case TODAY:
                dateStr = sdf.format(cal.getTime());
                break;
            case FIRST_DAY_OF_MONTH:
                cal.set(Calendar.DAY_OF_MONTH, 1);
                dateStr = sdf.format(cal.getTime());
                break;
            default:
                dateStr = "";
                break;
        }
        return dateStr;
    }
}
