package com.hengfeng.web.utils;

public enum ErrorBusinessEnum implements CommonError
{
    PARAMETER_VALIDATE_ERROR(10000, "参数不合法"),
    UNKOWN_ERROR(10002, "未知错误"),
    USER_NOT_EXISTS(10003, "用户信息不存在");
    private int errCode;
    private String errMsg;
    ErrorBusinessEnum(int errCode, String errMsg)
    {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrmsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
