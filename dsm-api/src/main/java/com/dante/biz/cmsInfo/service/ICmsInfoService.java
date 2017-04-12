package com.dante.biz.cmsInfo.service;

import java.util.List;

import com.dante.model.base.CommonResult;
import com.dante.model.base.PageParam;
import com.dante.model.cmsInfo.CmsInfo;
import com.github.pagehelper.PageInfo;

public interface ICmsInfoService {

	CmsInfo getCmsInfoById(CmsInfo cmsInfo) throws Exception;

	List<CmsInfo> queryCmsInfoList(PageParam params) throws Exception;

	PageInfo<CmsInfo> pageCmsInfoList(PageParam params) throws Exception;

	int deleteCmsInfo(CmsInfo cmsInfo) throws Exception;

	CommonResult saveCmsInfo(CmsInfo cmsInfo) throws Exception;

}
