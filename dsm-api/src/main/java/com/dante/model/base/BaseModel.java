package com.dante.model.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class BaseModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 346724244817202118L;

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
	
	

}
