package com.su.utils;

import javax.sql.DataSource;

import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.SqlServerMaxValueIncrementer;

/**
 * 
 * @author niegang
 * 
 * @description 发送http请求
 * 
 * @filename HttpUtil.java
 * 
 * @time 2011-6-15 下午05:26:36
 * 
 * @version 1.0
 */

public class EveryDataSourceId {
	private String incrementerName;
	private String columnName;
	private int cacheSize = 1;
	private DataSource dataSource;
	private String dataBase;
	private MySQLMaxValueIncrementer mySQLMaxValueIncrementer;
	private OracleSequenceMaxValueIncrementer oracleSequenceMaxValueIncrementer;
	private SqlServerMaxValueIncrementer sqlServerMaxValueIncrementer;

	public EveryDataSourceId() {
		super();
	}

	public EveryDataSourceId(String incrementerName, String columnName, int cacheSize, DataSource dataSource) {
		super();
		this.incrementerName = incrementerName;
		this.columnName = columnName;
		this.cacheSize = cacheSize;
		this.dataSource = dataSource;
	}

	public int getId() {
		int id = 0;
		if (null != this.dataBase && dataBase.contains("mysql")) {
			if (null == mySQLMaxValueIncrementer) {
				mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer(dataSource, incrementerName, columnName);
				mySQLMaxValueIncrementer.setCacheSize(cacheSize);
			}
			id = mySQLMaxValueIncrementer.nextIntValue();
		} else if (null != this.dataBase && dataBase.contains("oracle")) {
			if (null == oracleSequenceMaxValueIncrementer) {
				oracleSequenceMaxValueIncrementer = new OracleSequenceMaxValueIncrementer(dataSource, incrementerName);
			}
			id = oracleSequenceMaxValueIncrementer.nextIntValue();
		} else if (null != this.dataBase && dataBase.contains("sqlserver") || dataBase.contains("jtds")) {
			if (null == sqlServerMaxValueIncrementer) {
				sqlServerMaxValueIncrementer = new SqlServerMaxValueIncrementer(dataSource, incrementerName,
						columnName);
				sqlServerMaxValueIncrementer.setCacheSize(cacheSize);
			}
			id = sqlServerMaxValueIncrementer.nextIntValue();
		}
		return id;
	}

	public String getIncrementerName() {
		return incrementerName;
	}

	public void setIncrementerName(String incrementerName) {
		this.incrementerName = incrementerName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

}
