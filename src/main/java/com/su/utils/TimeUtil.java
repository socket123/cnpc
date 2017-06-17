package com.su.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class TimeUtil {
	
	public static Date stringToDate(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String getNowDate(){
		Date now = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = sdf.format( now ); 
		return nowDate;
	}
	
	public static String getNowDateHS(){
		Date now = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = sdf.format( now ); 
		return nowDate;
	}
	
	
	public static int daysOfTwo(Date fDate, Date oDate) {

       Calendar aCalendar = Calendar.getInstance();

       aCalendar.setTime(fDate);

       int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

       aCalendar.setTime(oDate);

       int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

       return day2 - day1;
    }
	
	/**  
     * 鐠侊紕鐣绘稉銈勯嚋閺冦儲婀℃稊瀣？閻╃妯婇惃鍕亯閺侊拷 
     * @param smdate 鏉堝啫鐨惃鍕闂傦拷
     * @param bdate  鏉堝啫銇囬惃鍕闂傦拷
     * @return 閻╃妯婃径鈺傛殶 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
	
	public static int daysOfTwo(String fDateStr, String oDateStr) throws ParseException{
		Date fDate = TimeUtil.stringToDate(fDateStr);
		Date oDate = TimeUtil.stringToDate(oDateStr);
		return TimeUtil.daysBetween(fDate, oDate);
	}
	
	/**
	 * 閼惧嘲褰囩拠銉︽闂傚娈戞稉锟藉嬀閸撳秶娈戦弮銉︽埂
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String getLostYear(String dateStr) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Date dt = sdf.parse(dateStr);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.YEAR,-1);//閺冦儲婀￠崙锟介獮锟�
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        System.out.println(reStr);
        
        return reStr;
	}
	
	/**
	 * 获取该时间的一年后的日期
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String getAddYear(String dateStr) throws ParseException{
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Date dt = sdf.parse(dateStr);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.YEAR,1);
        rightNow.add(Calendar.DATE, -1);
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        System.out.println(reStr);
        
        return reStr;
	}
	
	/**
	 * 转换时间戳
	 * @param dataStr 时间字符串，字段格式为:yyyy-MM-dd HH:mm:ss或yyyy-MM-dd 
	 *        为null时，获取当前时间戳
	 * @throws ParseException 
	 */
	public static long getTimestamp(String dataStr){
		SimpleDateFormat format = null;
		if (StringUtil.isNull(dataStr)){
			format = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date = new Date();
			dataStr =format.format(date);
		}else{
			if (dataStr.length() == 10){
				format = new SimpleDateFormat("yyyy-MM-dd"); 
			}else{
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
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
	 * 閺嶏繝鐛檍sTicket閻㈢喐鍨氶弮鍫曟？閺勵垰鎯佺搾鍛扮箖7000缁夛拷
	 * 
	 * @param publicAccount閵嗭拷鍙曟导妤�娇鐎电钖�
	 * @param timeStamp閵嗭拷缍嬮崜宥嗘）閺堢喐妞傞梻瀛樺煈
	 * @return閵嗭拷rue 鐡掑懎鍤弮鍫曟？閼煎啫娲�
	 */
	public static boolean validTime(String time, long timeStamp){
		
		if(time!=null){
			long timeLong = Long.parseLong(time);
			if ((timeStamp - timeLong)/1000 > 7000){
				return true;
			}
		}
		return false;
	}
	
	public static String timestampToDateStr(Long timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date(timestamp));
		//System.out.println(date);
		return date;
	}
	
	
	public static void main(String[] args) {
		System.out.println(TimeUtil.getNowDateHS());
	}
	
	
}
