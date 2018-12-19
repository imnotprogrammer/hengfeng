package com.hengfeng.web.utils;

/**
 * �ӿ�ȫ��ͳһ������
 * @author Administrator
 *
 */
public class ApiResponse {
	
	//��ʾ��Ϣ
	private String message;
	
	//����
	private Object data;
	
	//״̬�� �ɹ�ok ʧ�� fail
	private String status;
	
	/**
	 * ����һ��api��Ӧ
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
