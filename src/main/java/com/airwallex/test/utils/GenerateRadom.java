package com.airwallex.test.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @author CHAOJ
 */

public class GenerateRadom {

    public static String getRandomChinese(int len) {

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < len; i++) {
            String str = null;
            // 定义高低位
            int hightPos, lowPos;
            Random random = new Random();
            // 获取高位值
            hightPos = (176 + Math.abs(random.nextInt(39)));
            // 获取低位值
            lowPos = (161 + Math.abs(random.nextInt(93)));
            byte[] b = new byte[2];
            b[0] = (byte) hightPos;
            b[1] = (byte) lowPos;
            try {
                // 转成中文
                str = new String(b, "GBK");
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret.append(str);
        }
        return ret.toString();
    }

    public static String getRandomStringAndNumber(int len) {

        StringBuilder val = new StringBuilder();
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < len; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val.append((char) (random.nextInt(26) + temp));
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val.append(random.nextInt(10));
            }
        }
        return val.toString();
    }

    public static String getRandomString(int len) {

        StringBuilder val = new StringBuilder();
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < len; i++) {
            //输出是大写字母还是小写字母
            int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
            val.append((char) (random.nextInt(26) + temp));
        }
        return val.toString();
    }

    public static String getRandomNumber(int len) {

        StringBuilder val = new StringBuilder();
        Random random = new Random();

        //参数len，表示生成几位随机数
        for(int i = 0; i < len; i++) {
            val.append(random.nextInt(10));
        }
        return val.toString();
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            System.out.println(getRandomString(10));
        }
    }
}
