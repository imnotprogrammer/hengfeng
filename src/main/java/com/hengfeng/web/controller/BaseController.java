package com.hengfeng.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hengfeng.web.utils.ErrorBusinessEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengfeng.web.utils.ApiResponse;
import com.hengfeng.web.utils.BusinessException;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 基础控制器类
 * @author yuguo.lan
 *
 */
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

	/**
	 * 捕获全局异常，并返回统一值
	 * @param request
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)//指定拦截的异常
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ApiResponse exceptionHandler(HttpServletRequest request, Exception e) throws Exception
	{
		Map<String, Object> map = new HashMap<>();
		ApiResponse response = new ApiResponse();
		if (e instanceof BusinessException) {
			BusinessException be = (BusinessException) e;
			map.put("errCode", be.getErrCode());
			map.put("errMsg", be.getErrMsg());
			response.setData(map);
		} else {
			map.put("errCode", ErrorBusinessEnum.UNKOWN_ERROR.getErrCode());
			map.put("errMsg", e.getMessage());
			response.setData(map);
		}
		return response.createResponse(map, "fail");
	}

}
