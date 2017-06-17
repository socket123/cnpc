package com.su.utils;

import java.util.List;
import java.util.Map;

import com.su.dao.BaseDao;

public class Page<T> {
	// 每页显示条数
	private Integer pageNum;
	// 总记录数
	private Integer totalNum;
	// 总页数
	private Integer totalPage;
	// 当前页页码
	private Integer currentIndex;
	// 下一页页码
	private Integer nextPage;
	// 预加载页数
	private Integer preloadNum;
	// 上一页页码
	private Integer previousPage;
	
	private String shop_name;

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(Integer currentIndex) {
		this.currentIndex = currentIndex;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}

	/**
	 * @return the preloadNum
	 */
	public Integer getPreloadNum() {
		return preloadNum;
	}

	/**
	 * @param preloadNum
	 *            the preloadNum to set
	 */
	public void setPreloadNum(Integer preloadNum) {
		this.preloadNum = preloadNum;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	@SuppressWarnings("rawtypes")
	private void init() {
		this.pageNum = ((Page) SpringUtil.getBean("page")).getPageNum();
		this.preloadNum = ((Page) SpringUtil.getBean("page")).getPreloadNum();
	}

	private List<T> dataList;

	public Page() {

	}

	/**
	 * 分页
	 * 
	 * @param dao
	 *            分页的dao
	 * @param currentIndex
	 *            当前页码
	 */
	public Page(BaseDao<T> dao, Integer currentIndex, Map<String, Object> maps) {
		init();
		if (currentIndex != null) {
			this.currentIndex = currentIndex;
		} else {
			this.currentIndex = 1;
		}
		calculate(dao, maps);
	}

	/**
	 * 分页
	 * 
	 * @param dao
	 *            分页的dao
	 * @param currentIndex
	 *            当前页码
	 * @param pageNum
	 *            每页显示的数据的数量
	 */
	public Page(BaseDao<T> dao, Integer currentIndex, Integer pageNum, Map<String, Object> maps) {
		init();
		if (pageNum != null) {
			this.pageNum = pageNum;
		}
		if (currentIndex != null) {
			this.currentIndex = currentIndex;
		}
		calculate(dao, maps);
	}

	private void calculate(BaseDao<T> dao, Map<String, Object> maps) {
		int count = 0;
		count = dao.queryPageCount(maps);
		this.totalNum = count;
		this.totalPage = totalNum % pageNum == 0 ? totalNum / pageNum : totalNum / pageNum + 1;
		this.nextPage = currentIndex + 1;
		this.previousPage = currentIndex - 1;
		int beginIndex = previousPage * pageNum;
		maps.put("beginIndex", beginIndex);
		maps.put("endIndex", pageNum);
		dataList = dao.queryPage(maps);
	}
}