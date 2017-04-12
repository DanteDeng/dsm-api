package com.dante.model.cmsInfo;

import com.dante.model.base.BaseRecord;

public class CmsInfo extends BaseRecord{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 969629303807014592L;

	private String cmsId;

    private String cmsTitle;

    private String cmsAuthor;

    private String cmsImageUrl;

    private String cmsContent;

    /**
	 * 序列号
	 */
    public String getCmsId() {
        return cmsId;
    }

    public void setCmsId(String cmsId) {
        this.cmsId = cmsId == null ? null : cmsId.trim();
    }

    public String getCmsTitle() {
        return cmsTitle;
    }

    public void setCmsTitle(String cmsTitle) {
        this.cmsTitle = cmsTitle == null ? null : cmsTitle.trim();
    }

    public String getCmsAuthor() {
        return cmsAuthor;
    }

    public void setCmsAuthor(String cmsAuthor) {
        this.cmsAuthor = cmsAuthor == null ? null : cmsAuthor.trim();
    }

    public String getCmsImageUrl() {
        return cmsImageUrl;
    }

    public void setCmsImageUrl(String cmsImageUrl) {
        this.cmsImageUrl = cmsImageUrl == null ? null : cmsImageUrl.trim();
    }

    public String getCmsContent() {
        return cmsContent;
    }

    public void setCmsContent(String cmsContent) {
        this.cmsContent = cmsContent;
    }
}