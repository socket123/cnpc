/*
 * (C)2012 JiangSu HopeRun Corporation. 
 *       All rights reserved.
 */
package com.su.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}

	public static <T> T getObjectFormJsonByjackson(String jsonString,
			Class<T> clazz) {
		T jsonObject = null;
		try {
			jsonObject = mapper.readValue(jsonString, clazz);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

	public static String getJsonStrByObject(Object object) {
		String str = null;
		try {
			str = mapper.writeValueAsString(object);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
