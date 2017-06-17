package com.su.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 胡彪 on 2014/6/11.
 */
public class ArrayUtil
{
    public static List<String> Array2List(String[] strs)
    {
        List<String> ret = new ArrayList<String>();
        for (String str : strs)
        {
            ret.add(str);
        }
        return ret;
    }

    /**
     * 将字符串转换成一维数组
     * 
     * @param input
     * @param spliter
     * @return
     */
    public static String[] strToArray(String input, String spliter) {
        if ("".equals(input) || null == input) {
            return new String[] {};
        }
        if (input.indexOf(spliter) < 0) {
            return new String[] {
                input
            };
        } else {
            return input.split(spliter);
        }
    }

    public static  String str (String[] s ){
        String  strs = s[0]+"-"+s[1];
        return  strs;
    }


    /**
     * 循环截取list
     * 
     * @param alist,需要截取的list
     * @param offsize,每次截取个数
     * @return
     */
    public static List<List<String>> subListByNum(List<String> alist, int offsize) {
        List<List<String>> idlist = new ArrayList<List<String>>();
        if (null == alist || offsize == 0) {
            return idlist;
        }
        int listsize = alist.size();
        int dif = listsize / offsize;
        int modsize = listsize % offsize; // 判断是否多循环一次
        int loopsize = dif + 1;
        if (listsize == offsize) {
            loopsize = 1;
        } else if (modsize == 0) {
            loopsize = dif;
        }
        for (int i = 0; i < loopsize; i++) {
            List<String> templist = null;
            int nowoffsize = (i + 1) * offsize;
            if (offsize >= listsize) {
                templist = alist.subList(0, listsize);
            } else {
                if (nowoffsize <= listsize) {
                    templist = alist.subList(i * offsize, nowoffsize);
                } else {
                    templist = alist.subList(i * offsize, listsize);
                }
            }
            idlist.add(templist);
        }
        return idlist;
    }

}