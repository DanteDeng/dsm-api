package com.dante.model.apiInfo;

import com.dante.model.base.PageParam;

public class ApiInfoParam  extends PageParam{

	/**
	 * 序列号 
	 */
	private static final long serialVersionUID = -5562316582735435121L;
	
	private String searchText;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

}
