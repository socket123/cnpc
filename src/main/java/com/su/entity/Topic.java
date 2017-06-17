package com.su.entity;

public class Topic {
	
	/**
	 * 分类表id
	 */
	private String id;
	
	/**
	 * 分类名称
	 */
	private String name;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 创建人ID
	 */
	private String createUser;
	/**
	 * 创建人姓名
	 */
	private String createUserName;
	
	/**
	 * 删除状态
	 */
	private String status;
	
	/**
	 * 更新时间
	 */
	private String updateTime;
	
	/**
	 * 更新人
	 */
	private String updateUser;

	private String software;


	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", createTime=" + createTime + ", createUser=" + createUser
				+ ", createUserName=" + createUserName + ", status=" + status + ", updateTime=" + updateTime
				+ ", updateUser=" + updateUser + "]";
	}

	
	
}
