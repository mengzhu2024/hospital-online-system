package com.wk.hc.common.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class StringUtil {

    //校验密码
    public static boolean isTruePassword(String password) {
        String pattern = "^[0-9a-zA-Z_]{5,20}$";//5-20位字母数字下划线
        return Pattern.matches(pattern, password);
    }

    //下划线转驼峰
    public static String toHump(String s){
        if (s == null) {
            return null;
        }

        if (!s.contains("_")) {
            return s;
        }
        String[] arr = s.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                sb.append(arr[i]);
            }else {
                sb.append(arr[i].substring(0, 1).toUpperCase());
                sb.append(arr[i].substring(1).toLowerCase());
            }
        }

        return sb.toString();
    }

    public static boolean isNotBlank(String s) {
        return s != null && !s.equals("");
    }

    // 接收一个字符串，返回这个串的驼峰命名方式的结果
    public static String change(String s) {
        if (s == null) {
            return null;
        }
        if (!s.contains("_")) {// s中不包含下划线
            return s;
        }
        // work_no [work no]
        String[] arr = s.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i].substring(0, 1).toUpperCase());
                //arr[i]首字母大写之后再拼
                sb.append(arr[i].substring(1).toLowerCase());
            }
        }
        return sb.toString();// worko
    }

    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ignored) {
        }
        return null;
    }



    public static void main(String[] args) {

        String s = "work_no_info";
        System.out.println(change(s));
    }


}

