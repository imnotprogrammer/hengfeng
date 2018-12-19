package com.hengfeng.web.utils;

public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrmsg(String errMsg);
}
