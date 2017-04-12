package com.dante.model.base;

import java.util.Date;

public class BaseRecord extends BaseModel {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 4131329887835738524L;

	private static final String CREATE_BY = "dante";
	
	private static final String UPDATE_BY = "dante";

	/**
	 *	记录创建者
	 */
	private String createBy;

	/**
	 *	记录创建时间
	 */
	private Date createDate;

	/**
	 *	记录更新者
	 */
	private String updateBy;

	/**
	 *	记录更新时间
	 */
	private Date updateDate;
	
    public String getCreateBy() {
        return createBy==null?CREATE_BY:createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate==null?new Date():createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy==null?UPDATE_BY:updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate==null?new Date():updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
