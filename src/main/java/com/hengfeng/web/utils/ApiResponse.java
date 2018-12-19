package com.hengfeng.web.utils;

/**
 * 接口全局统一返回类
 * @author Administrator
 *
 */
public class ApiResponse {
	
	//提示信息
	private String message;
	
	//数据
	private Object data;
	
	//状态码 成功ok 失败 fail
	private String status;
	
	/**
	 * 创建一个api响应
	 * @param object
	 * @return
	 */
	public static ApiResponse createResponse(Object object)
	{
		ApiResponse response = new ApiResponse();
		response.setData(object);
		response.setMessage("");
		response.setStatus("ok");
		return response;
	}
	
	public static ApiResponse createResponse(Object object, String status)
	{
		ApiResponse response = new ApiResponse();
		response.setData(object);
		response.setMessage("");
		response.setStatus(status);
		return response;
	}
	
	public static ApiResponse createResponse(Object object, String status, String message)
	{
		ApiResponse response = new ApiResponse();
		response.setData(object);
		response.setMessage(message);
		response.setStatus(status);
		return response;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object object) {
		this.data = object;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
