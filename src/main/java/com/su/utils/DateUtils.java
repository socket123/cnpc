package com.su.utils;

/*
 *  Copyright  sunflower
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;


public class DateUtils
{
    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");



    ///
    public static Date currentdateFormat(String s) throws ParseException {

        return datetimeFormat.parse(s);
    }

    /**
     * 获得当前日期时间
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String currentDatetime()
    {
        return datetimeFormat.format(now());
    }

    /**
     * 格式化日期时间
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String formatDatetime(Date date)
    {
        return datetimeFormat.format(date);
    }

    /**
     * 格式化日期时间
     * 
     * @param date
     * @param pattern
     *            格式化模式，详见{@link SimpleDateFormat}构造器
     *            <code>SimpleDateFormat(String pattern)</code>
     * @return
     */
    public static String formatDatetime(Date date, String pattern)
    {
        SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat.clone();
        customFormat.applyPattern(pattern);
        return customFormat.format(date);
    }

    /**
     * 获得当前日期
     * <p>
     * 日期格式yyyy-MM-dd
     * 
     * @return
     */
    public static String currentDate()
    {
        return dateFormat.format(now());
    }

    /**
     * 格式化日期
     * <p>
     * 日期格式yyyy-MM-dd
     * 
     * @return
     */
    public static String formatDate(Date date)
    {
        return dateFormat.format(date);
    }

    /**
     * 获得当前时间
     * <p>
     * 时间格式HH:mm:ss
     * 
     * @return
     */
    public static String currentTime()
    {
        return timeFormat.format(now());
    }

    /**
     * 格式化时间
     * <p>
     * 时间格式HH:mm:ss
     * 
     * @return
     */
    public static String formatTime(Date date)
    {
        return timeFormat.format(date);
    }

    /**
     * 获得当前时间的<code>java.util.Date</code>对象
     * 
     * @return
     */
    public static Date now()
    {
        return new Date();
    }

    public static Calendar calendar()
    {
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return cal;
    }

    /**
     * 获得当前时间的毫秒数
     * <p>
     * 详见{@link System#currentTimeMillis()}
     * 
     * @return
     */
    public static long millis()
    {
        return System.currentTimeMillis();
    }

    /**
     * 
     * 获得当前Chinese月份
     * 
     * @return
     */
    public static int month()
    {
        return calendar().get(Calendar.MONTH) + 1;
    }

    /**
     * 获得月份中的第几天
     * 
     * @return
     */
    public static int dayOfMonth()
    {
        return calendar().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 今天是星期的第几天
     * 
     * @return
     */
    public static int dayOfWeek()
    {
        return calendar().get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 今天是年中的第几天
     * 
     * @return
     */
    public static int dayOfYear()
    {
        return calendar().get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 判断原日期是否在目标日期之前
     * 
     * @param src
     * @param dst
     * @return
     */
    public static boolean isBefore(Date src, Date dst)
    {
        return src.before(dst);
    }

    /**
     * 判断原日期是否在目标日期之后
     * 
     * @param src
     * @param dst
     * @return
     */
    public static boolean isAfter(Date src, Date dst)
    {
        return src.after(dst);
    }

    /**
     * 判断两日期是否相同
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqual(Date date1, Date date2)
    {
        return date1.compareTo(date2) == 0;
    }

    /**
     * 判断某个日期是否在某个日期范围
     * 
     * @param beginDate
     *            日期范围开始
     * @param endDate
     *            日期范围结束
     * @param src
     *            需要判断的日期
     * @return
     */
    public static boolean between(Date beginDate, Date endDate, Date src)
    {
        return beginDate.before(src) && endDate.after(src);
    }

    /**
     * 获得当前月的最后一天
     * <p>
     * HH:mm:ss为0，毫秒为999
     * 
     * @return
     */
    public static Date lastDayOfMonth()
    {
        Calendar cal = calendar();
        cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
        cal.set(Calendar.MINUTE, 0);// m置零
        cal.set(Calendar.SECOND, 0);// s置零
        cal.set(Calendar.MILLISECOND, 0);// S置零
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1
        cal.set(Calendar.MILLISECOND, -1);// 毫秒-1
        return cal.getTime();
    }

    /**
     * 获得当前月的第一天
     * <p>
     * HH:mm:ss SS为零
     * 
     * @return
     */
    public static Date firstDayOfMonth()
    {
        Calendar cal = calendar();
        cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
        cal.set(Calendar.MINUTE, 0);// m置零
        cal.set(Calendar.SECOND, 0);// s置零
        cal.set(Calendar.MILLISECOND, 0);// S置零
        return cal.getTime();
    }

    private static Date weekDay(int week)
    {
        Calendar cal = calendar();
        cal.set(Calendar.DAY_OF_WEEK, week);
        return cal.getTime();
    }

    /**
     * 获得周五日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * 
     * @return
     */
    public static Date friday()
    {
        return weekDay(Calendar.FRIDAY);
    }

    /**
     * 获得周六日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * 
     * @return
     */
    public static Date saturday()
    {
        return weekDay(Calendar.SATURDAY);
    }

    /**
     * 获得周日日期
     * <p>
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
     * 
     * @return
     */
    public static Date sunday()
    {
        return weekDay(Calendar.SUNDAY);
    }

    /**
     * 将字符串日期时间转换成java.util.Date类型
     * <p>
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     * 
     * @param datetime
     * @return
     */
    public static Date parseDatetime(String datetime) throws ParseException
    {
        return datetimeFormat.parse(datetime);
    }

    /**
     * 将字符串日期转换成java.util.Date类型
     * <p>
     * 日期时间格式yyyy-MM-dd
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException
    {
        return dateFormat.parse(date);
    }

    /**
     * 将字符串日期转换成java.util.Date类型
     * <p>
     * 时间格式 HH:mm:ss
     * 
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date parseTime(String time) throws ParseException
    {
        return timeFormat.parse(time);
    }

    /**
     * 根据自定义pattern将字符串日期转换成java.util.Date类型
     * 
     * @param datetime
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parseDatetime(String datetime, String pattern) throws ParseException
    {
        SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
        format.applyPattern(pattern);
        return format.parse(datetime);
    }

    /**
     * 生成随机文件名：当前年月日时分秒+四位随机数
     * 
     * @return
     */
    public static String getRandomFileName()
    {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;// 获取四位随机数
        return str + rannum;// 当前时间
    }

    public static String getRandomFileNameNew()
    {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;// 获取四位随机数
        return str + rannum;// 当前时间
    }

    public static String parseStrDateTimeToString(String strDate, String pattern, String format)
    {
        return dateToString(parseToDateTime(strDate, pattern), format);
    }

    public static Date parseToDateTime(String strDate, String pattern)
    {
        try
        {
            return (strDate == null || "".equals(strDate)) ? null : new SimpleDateFormat(pattern).parse(strDate);
        } catch (ParseException e)
        {
        }
        return null;
    }

    public static String dateToString(Date date, String format)
    {
        return new SimpleDateFormat(format).format(date);
    }
    /**
	 * 转换时间戳
	 * 
	 * @param dataStr
	 *            时间字符串，字段格式为:yyyy-MM-dd HH:mm:ss 为null时，获取当前时间戳
	 * @throws ParseException
	 */
	public static long getTimestamp(String dataStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
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
	 /**
		 * 时间戳转换
		 * @param wanglianzhong
		 * @param Long tiemLong
		 *            时间字符串，字段格式为:yyyy-MM-dd HH:mm:ss
		 * @throws Exception
		 */
	public static String changeTime(Long tiemLong ) {
		String tiemStr="";
		try {			
			tiemStr = datetimeFormat.format(tiemLong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tiemStr;
	}
	
	   /**
		 * 转换时间戳
		 * 
		 * @param dataStr
		 *            时间字符串，字段格式为:yyyy-MM-dd  为null或""时，获取当前时间戳
		 * @throws ParseException
		 */
		public static long changeTimestamp(String dataStr) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			if (StringUtil.isNull(dataStr) ) {
				try {
					dataStr = format.format(parseDate(currentDate()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			Date da = null;
			try {
				da = format.parse(dataStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return da.getTime();
		}
		
		  /**
			 * 转换时间戳
			 * 
			 * @param dataStr
			 *            时间字符串，字段格式为:yyyy-MM-dd HH:mm:ss  为null或""时，获取当前时间戳
			 * @throws ParseException
			 */
			public static long changeTimes(String dataStr) {
				
				if (StringUtil.isNull(dataStr) ) {
					try {
						dataStr = datetimeFormat.format(parseDate(currentDate()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				Date da = null;
				try {
					da = datetimeFormat.parse(dataStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return da.getTime();
			}
			 /**
			 * 转换时间戳
			 * 
			 * @param dataStr
			 *            时间字符串，字段格式为:yyyy-MM-dd HH:mm:ss  为null或""时，获取str分钟之后的时间戳
			 * @throws ParseException
			 */
			public static long getTimeStrAfter(String dataStr,String str){
				if(StringUtil.isNull(str)){
					str = "0";
				}
				Long longStr = Long.valueOf(str)*60*1000;
				Long longDataStr = DateUtils.changeTimes(dataStr);
				return longDataStr+longStr;
			}
			
			 /**
			 * 获取昨天时间
			 * 
			 *        时间字符串，字段格式为:yyyy-MM-dd  
			 * @throws ParseException
			 */
			public static String getTimeYesterday(){
				
				return changeTimeYMD(DateUtils.changeTimestamp("")-(long)24*60*60*1000);
			}
			 /**
			 * 时间戳转换
			 * @param wanglianzhong
			 * @param Long tiemLong
			 *            时间字符串，字段格式为:yyyy-MM-dd
			 * @throws Exception
			 */
		public static String changeTimeYMD(Long tiemLong ) {
			String tiemStr="";
			try {			
				tiemStr = dateFormat.format(tiemLong);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tiemStr;
		}
		
		/**
		 * 返回昨天是星期几
		 * @param date
		 * @return
		 */
		public static int getDayofweek(){  
		   Calendar cal = Calendar.getInstance();  
		   cal.setTime(new Date(System.currentTimeMillis() - 24*60*60*1000));  
		   return cal.get(Calendar.DAY_OF_WEEK);  
		} 
		
}
