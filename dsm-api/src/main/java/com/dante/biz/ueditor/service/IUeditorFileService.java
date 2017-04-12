package com.dante.biz.ueditor.service;

import java.util.List;
import java.util.Map;

import com.dante.model.ueditor.State;

public interface IUeditorFileService {
	
	public State listFile(int start, Map<String, Object> conf);

	public State capture(List<String> list, Map<String, Object> conf);

	public State saveBase64(String parameter, Map<String, Object> conf);

}
