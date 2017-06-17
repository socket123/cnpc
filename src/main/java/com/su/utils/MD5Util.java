package com.su.utils;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * Created by 胡彪 on 2015/3/25.
 */
public class MD5Util
{
    public final static String MD5(String s)
    {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        try
        {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++)
            {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSalt()
    {
        String uuid = UUID.randomUUID().toString();
        return MD5Util.MD5(uuid);
    }

    public static String getPass(String passWord, String salt)
    {
        return MD5Util.MD5(passWord + salt);
    }

    public static void main(String[] args)
    {
        String salt = MD5Util.getSalt();
        String pass = MD5Util.getPass("WYX2015.com", "");
        System.out.println(salt);
        System.out.println(pass);
    }
}
