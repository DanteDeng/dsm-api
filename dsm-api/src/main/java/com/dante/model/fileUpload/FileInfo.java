package com.dante.model.fileUpload;

import com.dante.model.base.BaseRecord;

/***
 * 文件信息
 * @author Administrator
 *
 */
public class FileInfo extends BaseRecord{
    /**
	 * 序列号
	 */
	private static final long serialVersionUID = 7103395092966898043L;

	/**
	 * 主键ID
	 */
	private String fileId;

	/**
	 * 文件目录路径
	 */
    private String filePath;

    /**
	 * 文件名称
	 */
    private String fileName;

    /**
	 * 文件后缀名
	 */
    private String fileSuffix;

    /**
	 * 文件大小
	 */
    private String fileSize;

    /**
	 * 文件MD5值
	 */
    private String fileMd5;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix == null ? null : fileSuffix.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5 == null ? null : fileMd5.trim();
    }

}