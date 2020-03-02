package com.mobei.common.util;

import java.util.Random;

/**
 * 数字类型的转换以及输出工具类定义
 *
 * @author lhl
 * @date 2018-08-09 下午 18:24
 *
 *
 */
public class NumberUtil {

    private static String str="0123456789";

    private static String CODE="012qwertQWERT345YUIOPyuiop678asdfASDFA9HJKLhjklzxcvbnmZXCVBNM";

    public static String getRandom(){
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }

        return sb.toString();
    }

    /**返回一个code随机码*/
    public static String toRandom(int num){

        StringBuilder sb=new StringBuilder(num);
        for(int i=0;i<num;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(getRandom());

    }
}
