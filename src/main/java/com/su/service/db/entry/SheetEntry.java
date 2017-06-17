package com.su.service.db.entry;

import java.util.List;
import java.util.Map;

public class SheetEntry {
	private String[] head;

	private String[] alias;

	private String[][] data;

	private String sheetName;

	private List<Map<String, String>> dataMap;

	/**
	 * 1.使用String[][]构造数据，2使用map构造数据
	 */
	private int type = 0;

	public SheetEntry(String sheetName, String[] head, String[][] data) {
		this.sheetName = sheetName;
		this.head = head;
		this.data = data;
		this.type = 1;
	}

	public SheetEntry(String sheetName, String[] head, String[] alias,
			List<Map<String, String>> dataMap) {
		this.sheetName = sheetName;
		this.head = head;
		this.alias = alias;
		this.dataMap = dataMap;
		this.type = 2;
	}

	public String[] getHead() {
		return head;
	}

	public void setHead(String[] head) {
		this.head = head;
	}

	public String[] getAlias() {
		return alias;
	}

	public void setAlias(String[] alias) {
		this.alias = alias;
	}

	public String[][] getData() {
		return data;
	}

	public void setData(String[][] data) {
		this.data = data;
	}

	public List<Map<String, String>> getDataMap() {
		return dataMap;
	}

	public void setDataMap(List<Map<String, String>> dataMap) {
		this.dataMap = dataMap;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
}
