/**
	Ztree实体类
 * 
 */
package com.su.entity;

/**
 * @author zhq
 * 
 */
public class ZtreeEntity {
	private Long id;// 菜单编号
	private Long pId;// 父菜单编号
	private String name;// 菜单名称
	private String url;// 链接
	private String target;// target 默认链接到rightFrame
	private String checked;
	private Boolean open;

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @return type
	 */

	public Long getId() {
		return id;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @return type
	 */

	public Long getpId() {
		return pId;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @param pId
	 */
	public void setpId(Long pId) {
		this.pId = pId;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @return type
	 */

	public String getName() {
		return name;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @return type
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @return type
	 */

	public String getTarget() {
		return target;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @return type
	 */

	public String getChecked() {
		return checked;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @param checked
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @return type
	 */

	public Boolean getOpen() {
		return open;
	}

	/**
	 * @author zhanghongqi
	 * @created 2015年8月14日 下午3:40:27
	 * @param open
	 */
	public void setOpen(Boolean open) {
		this.open = open;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ZtreeEntity [id=" + id + ", pId=" + pId + ", name=" + name
				+ ", url=" + url + ", target=" + target + ", checked="
				+ checked + ", open=" + open + "]";
	}

}
