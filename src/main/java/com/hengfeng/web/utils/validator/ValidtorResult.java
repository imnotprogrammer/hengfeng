package com.hengfeng.web.utils.validator;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ValidtorResult {

    public Boolean hasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public Map<String, String>  getErrMessageMap() {
        return errMessage;
    }
    public String  getErrMessage() {
        return StringUtils.join(errMessage.values().toArray(), ",");
    }

    public void setErrMessage(Map<String, String> errMessage) {
        this.errMessage = errMessage;

    }

    private Boolean hasError = false;
    private Map<String, String> errMessage = new HashMap<>();
}
