package com.hengfeng.web.controller;

import javax.annotation.Resource;

import com.hengfeng.web.table.User;
import com.hengfeng.web.utils.BusinessException;
import com.hengfeng.web.utils.ErrorBusinessEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengfeng.web.service.UserService;
import com.hengfeng.web.utils.ApiResponse;

@Controller
public class UserController extends BaseController{
	@Resource
	private UserService userService;
	
	@RequestMapping("/user")
	@ResponseBody
	public ApiResponse home() throws BusinessException
	{
		User user = userService.selectById(2);
		if (user == null) {
			throw new BusinessException(ErrorBusinessEnum.USER_NOT_EXISTS);
		}
		return ApiResponse.createResponse(user);
	}
	
	@RequestMapping("/user/update")
	@ResponseBody
	public int updateUser(@RequestParam(required=true) int user_id,
			@RequestParam(required=true) String username,
			@RequestParam(required=true) String email)
	{
		User user = new User();
		user.setId(user_id);
		user.setName(username);;
		user.setEmail(email);
		return userService.setUserInfo(user);
	}

	public ApiResponse login()
	{
		return new ApiResponse();
	}
}
