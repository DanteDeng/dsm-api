package com.dante.model.fileUpload;

import com.dante.model.base.BaseModel;

/**
 * 此类用来保存文件的信息，因为是用来传值，所以文件转为String
 * @author Administrator
 *
 */
public class FileInfoParam extends BaseModel{
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -9082293576332423622L;
	
	/**
	 * 文件路径（相对路劲，不包含文件名称及后缀）
	 */
	private String filePath;
	
	/**
	 * 文件名称（不包含后缀）
	 */
	private String fileName;
	
	/**
	 * 文件后缀名
	 */
	private String fileSuffix;
	
	/**
	 * 文件转做的base64字符串
	 */
	private String fileString;
	
	/**
	 * 是否去重重复文件
	 */
	private boolean checkSameFile;
	
	/**
	 * 去重重复文件是否包括子目录
	 */
	private boolean checkSubFile;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getFileString() {
		return fileString;
	}

	public void setFileString(String fileString) {
		this.fileString = fileString;
	}

	public boolean isCheckSameFile() {
		return checkSameFile;
	}

	public void setCheckSameFile(boolean checkSameFile) {
		this.checkSameFile = checkSameFile;
	}

	public boolean isCheckSubFile() {
		return checkSubFile;
	}

	public void setCheckSubFile(boolean checkSubFile) {
		this.checkSubFile = checkSubFile;
	}
}
