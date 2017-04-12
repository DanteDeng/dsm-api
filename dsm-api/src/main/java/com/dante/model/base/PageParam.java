package com.dante.model.base;

import com.alibaba.fastjson.JSONObject;

public class PageParam extends BaseModel {

	/**
	* 序列号
	*/
	private static final long serialVersionUID = -8455557852860580586L;
	
	private Integer pageNum;
	private Integer pageSize;

	public Integer getPageNum() {
		return pageNum==null?1:pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize==null?10:pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
	
}
