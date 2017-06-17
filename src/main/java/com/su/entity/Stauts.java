package com.su.entity;

/**
 * 状态信息实体
 * @author Administrator
 *
 */
public class Stauts {
	// 状态码
	private String resCode;
	
	// 状态信息
	private String resMsg;
	
	// 内容
	private Object resContent;

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public Object getResContent() {
		return resContent;
	}

	public void setResContent(Object resContent) {
		this.resContent = resContent;
	}
	
	
	
	
}
