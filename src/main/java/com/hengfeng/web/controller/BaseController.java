package com.hengfeng.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengfeng.web.utils.ApiResponse;
import com.hengfeng.web.utils.BusinessException;

/**
 * 鍩虹鍏叡绫�
 * @author Administrator
 *
 */
public class BaseController {
	protected ApiResponse response;
	@ExceptionHandler(value = Exception.class)//指定拦截的异常
	@ResponseBody
	public ApiResponse exceptionHandler(HttpServletRequest request, HttpServletResponse response,Exception e) throws Exception
	{
		if (e instanceof BusinessException) {
			
		} else {
			//this.response.setData(object);
			
		}
		return this.response;
	}

}
