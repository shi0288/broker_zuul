package com.xyauto.interact.broker.zuul.util;


import com.xyauto.common.library.redis.RedisPoolUtil;
import java.security.MessageDigest;
import java.util.List;
import java.util.regex.Pattern;

public class Util {


    public static void main(String[] args) {
        RedisPoolUtil.INSTANCE.init("192.168.3.63:6379","",1000);
    }


    public static String listToString(List list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    sb.append(list.get(i) + ",");
                } else {
                    sb.append(list.get(i));
                }
            }
        }
        return sb.toString();
    }


    public static String MD5(String pwd) {
        //用于加密的字符  
        char md5String[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中  
            byte[] btInput = pwd.getBytes();

            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要  
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文  
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式  
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {   //  i = 0  
                byte byte0 = md[i];  //95  
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5   
                str[k++] = md5String[byte0 & 0xf];   //   F  
            }

            //返回经过加密后的字符串  
            return new String(str);

        } catch (Exception e) {
            return null;
        }
    }

    public static String getRandomLetter(int lenth) {
        StringBuffer stringBuffer = new StringBuffer();
        if (lenth < 1) {
            lenth = 1;
        }
        for (int i = 0; i < lenth; i++) {
            stringBuffer.append(String.valueOf((char) (int) (Math.random() * 26 + 97)));
        }
        return stringBuffer.toString();
    }

    public static boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }


    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }


}
