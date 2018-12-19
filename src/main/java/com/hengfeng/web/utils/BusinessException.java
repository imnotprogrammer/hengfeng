package com.hengfeng.web.utils;

public class BusinessException extends Exception implements CommonError{
	private CommonError cr;

	public BusinessException(CommonError cr)
	{
		super();
		this.cr = cr;
	}
	public BusinessException(CommonError cr, String errMsg)
	{
		super();
		this.cr = cr;
		this.cr.setErrmsg(errMsg);
	}

	@Override
	public int getErrCode() {
		return this.cr.getErrCode();
	}

	@Override
	public String getErrMsg() {
		return this.cr.getErrMsg();
	}

	@Override
	public CommonError setErrmsg(String errMsg) {
		this.cr.setErrmsg(errMsg);
		return this;
	}
}
