package com.su.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class CommonUtil {

  protected final static Log logger = LogFactory.getLog(CommonUtil.class);

  private static long orderNum = 0l;
  private static String date;

  /**
   * 拼接路径
   * 
   * @param request
   * @return
   */
  public static String getBasePath(HttpServletRequest request) {
    return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
        + request.getContextPath() + "/";
  }

  /**
   * 獲取userId-session
   * 
   * @return
   */
  public static String getSession(HttpServletRequest request, String key) {

    String str = "0";

    if (request.getSession().getAttribute(key) != null) {
      str = request.getSession().getAttribute(key) + "";
    }

    return str;
  }

  /**
   * 獲取object-session
   * 
   * @return
   */
  public static Object getSessionObj(HttpServletRequest request, String key) {

    Object obj = null;

    if (request.getSession().getAttribute(key) != null) {
      obj = request.getSession().getAttribute(key);
    }

    return obj;
  }

  /**
   * 清空-session
   * 
   * @return
   */
  public static void removeSession(HttpServletRequest request, String key) {
    if (request.getSession().getAttribute(key) != null) {
      request.getSession().removeAttribute(key);
    }
  }

  /**
   * 獲取userId-request
   * 
   * @return
   */
  public static String getRequest(HttpServletRequest request, String key) {
    String str = "0";

    if (StringUtils.isNotEmpty(request.getParameter(key))) {
      str = request.getParameter(key) + "";
    }

    return str;
  }

  public static Object getRequestObj(HttpServletRequest request, String key) {
    Object obj = null;

    if (request.getParameter(key) != null) {
      obj = request.getParameter(key);
    }

    return obj;

  }

  public static void setSession(HttpServletRequest request, String key, Object value) {
    request.getSession().setAttribute(key, value);

  }

  /**
   * 创建指定数量的随机字符串
   * 
   * @param numberFlag 是否是数字
   * @param length
   * @return
   */
  public static String createRandom(boolean numberFlag, int length) {

    String retStr = "";

    String strTable =
        numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyzABCDEFGHIJKMNPQRSTUVWXYZ";

    int len = strTable.length();

    boolean bDone = true;

    do {

      retStr = "";

      int count = 0;

      for (int i = 0; i < length; i++) {

        double dblR = Math.random() * len;

        int intR = (int) Math.floor(dblR);

        char c = strTable.charAt(intR);

        if (('0' <= c) && (c <= '9')) {

          count++;

        }

        retStr += strTable.charAt(intR);

      }

      if (count >= 2) {

        bDone = false;

      }

    } while (bDone);

    return retStr;
  }

  /**
   * 获取客户端的ip地址
   * 
   * @param request
   * @return
   */
  public static String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("http_client_ip");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
    }
    // 如果是多级代理，那么取第一个ip为客户ip
    if (ip != null && ip.indexOf(",") != -1) {
      ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
    }
    return ip;
  }

  /**
   * 转换时间戳
   * 
   * @param dataStr 时间字符串，字段格式为:yyyy-MM-dd HH:mm:ss 为null时，获取当前时间戳
   * @throws ParseException
   */
  public static long getTimestamp(String dataStr) {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    if (null == dataStr) {
      Date date = new Date();
      dataStr = format.format(date);
    }
    Date da = null;
    try {
      da = format.parse(dataStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return da.getTime();
  }


  public static String getChannelCode(String str) {
    String channelCode = str.substring(0, 6);
    return channelCode;
  }

  public static String getOrderNo() {
    String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());

    if (date == null || !date.equals(str)) {
      date = str;
      orderNum = 0l;
    }
    orderNum++;


    long orderNo = Long.parseLong((date)) * 10000;
    orderNo += orderNum;;

    return orderNo + "";

  }

  /**
   * 获取区间随机数
   * 
   * @param min 随机数的起始值
   * @param max 随机数的最大值
   * @return
   */
  public static int random(int min, int max) {

    Random random = new Random();
    int s = random.nextInt(max) % (max - min + 1) + min;

    return s;
  }

  /**
   * 过滤emoji 或者 其他非文字类型的字符
   * 
   * @param source
   * @return
   */
  public static String filterEmoji(String source) {
    int len = source.length();
    StringBuilder buf = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      char codePoint = source.charAt(i);
      if (isNotEmojiCharacter(codePoint)) {
        buf.append(codePoint);
      }
    }
    return buf.toString();
  }

  private static boolean isNotEmojiCharacter(char codePoint) {
    return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
        || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
        || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
        || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
  }
}
