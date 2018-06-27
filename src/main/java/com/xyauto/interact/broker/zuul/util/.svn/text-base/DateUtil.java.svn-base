package com.xyauto.interact.broker.zuul.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {
	public static String formatDate = "yyyyMMdd";
    
    

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(seconds.length()==13)
        {
            seconds = String.valueOf(Long.valueOf(seconds)/1000);
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
  //日期转字符串
    public static String dateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
        return sdf.format(date);
    }
    
    public static String longToDateString(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
        return sdf.format(date);
    }
}
