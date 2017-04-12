package com.dante.biz.fileUpload.service;

import java.util.List;

import com.dante.model.fileUpload.Image;
import com.dante.model.base.PageParam;
import com.github.pagehelper.PageInfo;

public interface IImageService {

	Image getImageById(Image i) throws Exception;

	List<Image> queryImageList(PageParam params) throws Exception;

	PageInfo<Image> pageImageList(PageParam params) throws Exception;

	void addImage(Image image) throws Exception;

	int updateImage(Image image) throws Exception;

	int deleteImage(Image image) throws Exception;

}
