package com.dwg.egou;

/**
 * Created by Administrator on 2016/4/23.
 */
public class MyUtils {
    private static final String RANDOMS = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getCheckCode(int num) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * RANDOMS.length());
            buffer.append(RANDOMS.charAt(rand));
        }
        return buffer.toString();
    }
}
