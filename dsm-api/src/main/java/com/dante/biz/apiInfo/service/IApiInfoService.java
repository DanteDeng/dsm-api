package com.dante.biz.apiInfo.service;

import java.util.List;

import com.dante.model.apiInfo.ApiInfo;
import com.dante.model.apiInfo.ApiInfoParam;
import com.dante.model.base.CommonResult;
import com.github.pagehelper.PageInfo;

public interface IApiInfoService {

	List<ApiInfo> queryApiInfoList(ApiInfoParam param) throws Exception;

	PageInfo<ApiInfo> pageApiInfoList(ApiInfoParam param) throws Exception;

	CommonResult saveApiInfo(ApiInfo apiInfo) throws Exception;

	ApiInfo queryApiInfoDetail(ApiInfo apiInfo) throws Exception;

	CommonResult deleteApiInfo(ApiInfo apiInfo) throws Exception;

}
