package com.su.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	public static <T> T getObject(String jsonString, Class<T> cls) {
		T t = null;
		try {
			Gson gson = new Gson();
			t = gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * type = new com.google.gson.reflect.TypeToken.TypeToken()
	 * 
	 * @param jsonStr
	 * @param type
	 * @return
	 */

	public static <T> List<T> jsonToList(String jsonStr,
			java.lang.reflect.Type type) {
		List<T> objList = null;
		Gson gson = new Gson();
		if (gson != null) {
			objList = gson.fromJson(jsonStr, type);
		}
		return objList;
	}

	/**
	 * json对象转换成List<Map<String,Object>>
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> listKeyMaps(String jsonString) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			Gson gson = new Gson();
			list = gson.fromJson(jsonString,
					new TypeToken<List<Map<String, Object>>>() {
					}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * json对象转换成Map<String,Object>
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Map<String, Object> jsonStrToMap(String jsonString) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Gson gson = new Gson();
			map = gson.fromJson(jsonString,
					new TypeToken<Map<String, Object>>() {
					}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * object转换成json 字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String createJsonString(Object value) {
		Gson gson = new Gson();
		String str = gson.toJson(value);
		return str;
	}

}
