package com.dante.biz.fileUpload.service;

import java.util.List;

import com.dante.model.fileUpload.FileInfoParam;

public interface IFileOperationService {
	
	/**
	 * 根据传入的文件信息保存文件
	 * @param fileInfo
	 * @return
	 * @throws Exception
	 */
	String saveFile(FileInfoParam fileInfo) throws Exception;
	
	/**
	 * 查找相应路径下的文件列表
	 * @param fileInfo
	 * @return
	 * @throws Exception
	 */
	List<String> listFile(FileInfoParam fileInfo) throws Exception;
	
	/**
	 * 删除指定路径下的文件
	 * @param fileInfo
	 * @return
	 * @throws Exception
	 */
	boolean deleteFile(FileInfoParam fileInfo) throws Exception;

}
