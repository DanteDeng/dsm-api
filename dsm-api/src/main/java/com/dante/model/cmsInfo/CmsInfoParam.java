package com.dante.model.cmsInfo;

import com.dante.model.base.PageParam;

public class CmsInfoParam  extends PageParam{

	/**
	 * 序列号 
	 */
	private static final long serialVersionUID = 5702601235100167148L;
	
	private String searchText;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

}
