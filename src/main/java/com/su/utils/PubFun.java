package com.su.utils;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import sun.misc.BASE64Encoder;

/**
 * 
 * 公用工具类
 * */
@SuppressWarnings("restriction")
public class PubFun {

    /**
     * 生成UUID
     * 
     * @return String
     * */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23)
                + uuid.substring(24);
    }

    public static boolean isUrl(String url) {
        boolean ret = false;
        Pattern p = Pattern.compile("http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*");
        Matcher m = p.matcher(url);
        ret = m.matches();
        ret = true;
        return ret;
    }

    @SuppressWarnings("unused")
	public static boolean isDate(String dateString) {
        boolean ret = true;
        try {
            java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            Date date = sf.parse(dateString);
        } catch (java.text.ParseException e) {
            ret = false;
        }

        return ret;

    }

    public static boolean isMobile(String mobile) {
        boolean ret = false;

        if (StringUtil.isNull(mobile))
            return false;
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobile);
        ret = m.matches();

        return ret;
    }

    public static boolean isInt(String str) {
        boolean ret = false;

        Pattern p = Pattern.compile("^\\d*[1-9]\\d*$");
        Matcher m = p.matcher(str);
        ret = m.matches();

        return ret;
    }

    public static String getRandom(int num) {
        StringBuffer sbf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            sbf.append(new Random().nextInt(9));
        }
        return sbf.toString();
    }

    public static String arrayEnCode(String[][] arr) {
        StringBuilder sb = new StringBuilder();
        if (arr != null && arr.length > 0) {
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                String[] ar = arr[i];
                for (int j = 0; j < ar.length; j++) {
                    sb.append(ar[j]);
                    if (j != ar.length - 1) {
                        sb.append("\271A");
                    }
                }
                if (i != len - 1) {
                    sb.append("\271A\271A");
                }
            }
        }
        return sb.toString();
    }

    public static String[][] arrayDeCode(String str) {
        String[] arr = str.split("\271A\271A");
        int len = arr.length;
        String[][] arrRet = new String[len][];
        for (int i = 0; i < len; i++) {
            arrRet[i] = arr[i].split("\271A");
        }
        return arrRet;
    }

    public static String arrayJoin(String[] arr, String expr) {
        StringBuilder sb = new StringBuilder();
        if (arr != null && arr.length > 0) {
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                sb.append(arr[i]).append(expr);
            }
            len = sb.toString().length();
            sb.delete(len - expr.length(), len);
        }
        return sb.toString();
    }

    public static String produceDegistCode() {
        String seq = PubFun.getUUID();
        try {
            MessageDigest md5Code = MessageDigest.getInstance("md5");
            byte[] bTmp = md5Code.digest(seq.getBytes());
            // 采用base64算法将字节数组转换成字符串
            BASE64Encoder base64 = new BASE64Encoder();
            seq = base64.encode(bTmp).substring(0, 20);
            // seq="HvB+1PkB+tbqxeBF46A/";
            if (seq.indexOf("+") != -1) {
                seq = seq.replace("+", "b");
            }
            if (seq.indexOf("/") != -1) {
                seq = seq.replace("/", "a");
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return seq;
    }

    @SuppressWarnings({ "deprecation", "rawtypes"})
    public static Object JsonToObject(JSONObject json, Class pojo) throws Exception {
        // 首先得到pojo所定义的字段
        Field[] fields = pojo.getDeclaredFields();
        // 根据传入的Class动态生成pojo对象
        Object obj = pojo.newInstance();
        for (Field field : fields) {
            // 设置字段可访问（必须，否则报错）
            field.setAccessible(true);
            // 得到字段的属性名
            String name = field.getName();
            // 这一段的作用是如果字段在JSONObject中不存在会抛出异常，如果出异常，则跳过。
            try {
                json.get(name);
            } catch (Exception ex) {
                continue;
            }
            if (json.get(name) != null && !"".equals(json.getString(name))) {
                // 根据字段的类型将值转化为相应的类型，并设置到生成的对象中。
                if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
                    field.set(obj, Long.parseLong(json.getString(name)));
                } else if (field.getType().equals(String.class)) {
                    field.set(obj, json.getString(name));
                } else if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                    field.set(obj, Double.parseDouble(json.getString(name)));
                } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                    field.set(obj, Integer.parseInt(json.getString(name)));
                } else if (field.getType().equals(Date.class)) {
                    field.set(obj, Date.parse(json.getString(name)));
                } else {
                    continue;
                }
            }
        }
        return obj;
    }

    /**
     * 汉字转换位汉语拼音首字母，英文字符不变
     * 
     * @param chines
     *            汉字
     * @return 拼音
     */
    public static String converterToFirstSpell(String chines) {
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    pinyinName += nameChar[i];
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }

    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    public static void main(String[] args) {
        System.out.println(produceDegistCode());
    }
}
