package com.dante.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dante.model.fileUpload.FileInfo;

public class FileInfoUtil {
	/**
	 * 获取单个文件的MD5值！
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileMD5(File file) {
		if (!file.isFile()) {
			return null;
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}

	/**
	 * 获取字符数组（二进制文件）MD5值！
	 * 
	 * @param bytes
	 * @return
	 */
	public static String getBytesMD5(byte[] bytes) {
		if (bytes == null) { // 传入空数组则返回null
			return null;
		}
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}

	/**
	 * 获取文件夹中文件的MD5值
	 * 
	 * @param file
	 * @param listChild
	 *            ;true递归子目录中的文件
	 * @return Map<String, String> key 为文件路径， value为文件MD5值
	 */
	public static Map<String, String> getDirMD5(File file, boolean listChild) {
		if (!file.isDirectory()) {
			return null;
		}
		// <filepath,md5>
		Map<String, String> map = new HashMap<String, String>();
		String md5;
		File files[] = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory() && listChild) {
				map.putAll(getDirMD5(f, listChild));
			} else {
				md5 = getFileMD5(f);
				if (md5 != null) {
					map.put(f.getPath(), md5);
				}
			}
		}
		return map;
	}

	/**
	 * 通过数据库记录的文件信息获得完整的文件绝对路径名称信息，如：D:\BaiduNetdiskDownload\aa.jpg
	 * 
	 * @param file
	 * @return
	 */
	public static String getAbsolutePath(FileInfo file) {
		if (file == null) {
			return null;
		}
		String absolutePath = formatPathString(file.getFilePath(),file.getFileName() + "." + file.getFileSuffix(),File.separator);
		return absolutePath;
	}

	/**
	 * 获得已有相同文件的URL
	 * @param fileMD5
	 * @param fileList
	 * @return	返回为null时说明没有相同文件
	 */
	public static String getOldRepeatFileUrl(String fileMD5, List<FileInfo> fileList,String rootPath,String baseUrl) {
		for (FileInfo fi : fileList) { // 遍历对比文件的MD5值
			if (fi.getFileMd5() != null && fi.getFileMd5().equals(fileMD5)) {
				return formatFileUrl(getAbsolutePath(fi),rootPath,baseUrl);
			}
		}
		return null;
	}

	/**
	 * 文件路径转换为网络可访问的Url链接
	 * @param absolutePath
	 * @param rootPath
	 * @param baseUrl
	 * @return
	 */
	public static String formatFileUrl(String absolutePath,String rootPath,String baseUrl) {
		absolutePath = absolutePath.replace("\\", "/"); // 文件路径分隔符\转为网络路径分隔符/
		rootPath = rootPath.replace("\\", "/");
		baseUrl = baseUrl.replace("\\", "/");
		absolutePath = absolutePath.replace(rootPath, ""); // 替换掉根路径
		return formatPathString(baseUrl, absolutePath, "/");
	}

	/**
	 * 相对路径转绝对路径
	 * @param filePath
	 * @param rootPath
	 * @return
	 */
	public static String formatAbsolutePath(String filePath,String rootPath) {
		filePath = filePath.replace("/", File.separator); // 纠正连接符
		rootPath = rootPath.replace("/", File.separator);  
		return formatPathString(rootPath, filePath, File.separator);
	}

	/**
	 *  处理文件路径字符串拼接
	 * @param absolute
	 * @param relative
	 * @param separator
	 * @return
	 */
	public static String formatPathString(String absolute, String relative, String separator) {
		String result = null;
		if (absolute != null && relative != null) {
			if (!absolute.endsWith(separator) && !relative.startsWith(separator)) {
				result = absolute + separator + relative;
			} else if (absolute.endsWith(separator) && relative.startsWith(separator)) {
				relative = relative.substring(1);
				result = absolute + relative;
			} else {
				result = absolute + relative;
			}
		}
		return result;
	}
	/**
	 *	获取文件路径，不包含文件名部分
	 * @param file
	 * @return
	 */
	public static String getFilePath(File file){
		if(file==null){
			return null;
		}
		return file.getAbsolutePath().replace(file.getName(), "");
	}
	
	/**
	 * 获取文件的名称，不包括路径以及后缀
	 * @param file
	 * @return
	 */
	public static String getFileName(File file){
		if(file==null){
			return null;
		}
		String fileName = file.getName();
		return fileName.substring(0,fileName.lastIndexOf("."));
	}
	
	/**
	 * 获取文件后缀名，不包括 .
	 * @param file
	 * @return
	 */
	public static String getFileSuffix(File file){
		if(file==null){
			return null;
		}
		String fileName = file.getName();
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
	
	/**
	 * 获取文件大小，单位byte
	 * @param file
	 * @return
	 */
	public static long getFileSize(File file){
		if(file==null){
			return 0;
		}
		return file.length();
	}
	
	/**
	 * 设置文件信息
	 * @param file
	 * @return
	 */
	public static FileInfo getFileInfo(File file){
		if(file==null){
			return null;
		}
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(getFileName(file));
		fileInfo.setFilePath(getFilePath(file));
		fileInfo.setFileSuffix(getFileSuffix(file));
		fileInfo.setFileSize(""+getFileSize(file));
		fileInfo.setFileMd5(getFileMD5(file));
		return fileInfo;
	}
	
	/**
	 * 设置文件信息
	 * @param file
	 * @return
	 */
	public static FileInfo getFileInfo(File file,String fileMD5){
		if(file==null){
			return null;
		}
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(getFileName(file));
		fileInfo.setFilePath(getFilePath(file));
		fileInfo.setFileSuffix(getFileSuffix(file));
		fileInfo.setFileSize(""+getFileSize(file));
		if(fileMD5!=null){
			fileInfo.setFileMd5(fileMD5);
		}else{
			fileInfo.setFileMd5(getFileMD5(file));
		}
		return fileInfo;
	}
	
	/*public static void main(String[] args) {
		File file = new File("D:/BaiduNetdiskDownload/hadoop高级应用(免费赠送部分).7z");
		System.out.println("file.getAbsolutePath():"+file.getAbsolutePath());
		System.out.println("file.getName():"+file.getName());
		System.out.println("file.getPath():"+file.getPath());
		System.out.println("file.length():"+file.length());
	}*/

}
