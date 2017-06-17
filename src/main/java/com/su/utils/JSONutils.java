package com.su.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;


public class JSONutils {
	/**
	 * 对象转json
	 * 
	 * @param object
	 *            要转换的对象
	 * @return 转成的json数据
	 */
	public static String ObjectToJson(Object object) {
		return JSON.toJSONString(object);
	}

	/**
	 * MAP转json
	 * 
	 * @param object
	 *            要转换的对象
	 * @return 转成的json数据
	 */
	public static String MapToJson(Map<String, Object> map) {
		return JSON.toJSONString(map);
	}

	/**
	 * json转对象
	 * 
	 * @param json
	 * @return
	 */
	public static Object jsonToObject(String json) {
		return JSON.parse(json);
	}

	/**
	 * list转Json
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String listToJson(List list) {
		JSONArray jsonArray = JSONArray.fromObject(list);

		return jsonArray.toString();
	}

	/**
	 * list转Json
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

	/**
	 * json转list
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List jsonToList(String json) {
		return JSON.parseObject(json, new TypeReference<ArrayList>() {
		});
	}

	public static List<?> jsoToListObject(String json) {
		return JSON.parseObject(json, new TypeReference<ArrayList<Object>>() {
		});
	}

	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {

		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T bean = (T) JSONObject.toBean(jsonObject, beanCalss);

		return bean;

	}

	public static void flushResponse(HttpServletResponse response,
			String responseContent) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(responseContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	}

}
