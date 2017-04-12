package com.dante.model.base;

public class CommonResult extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3409558519290126193L;

	public static final String RESULT_SECCESS = "0";
	
	public static final String RESULT_FAIL = "1";
	
	public static final String INSERT_SUCCESS = "新增成功";
	
	public static final String UPDATE_SUCCESS = "修改成功";
	
	public static final String UPDATE_FAIL = "修改失败";
	 
	public static final String DELETE_SUCCESS = "删除成功";
	
	public static final String DELETE_FAIL = "删除失败";
	
	public static final String LOGIN_SUCCESS = "登录成功";
	
	public static final String LOGOUT_SUCCESS = "登出成功";
	
	public static final String DELETE_NO_VALUE = "请选择要删除的数据";
	
	public static final String NO_SUCH_USER = "帐号或密码错误";
	
	public static final String SYSTEM_ERROR = "系统异常";

	public static final String NO_PERMISSION = "没有权限";
	
	public static final String LACK_REQUIRED_PARAM = "缺少必要参数";
	
	private String code;
	private String message;
	private Object data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
