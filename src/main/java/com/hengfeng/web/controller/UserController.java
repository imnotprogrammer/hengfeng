package com.hengfeng.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengfeng.web.service.UserService;
import com.hengfeng.web.table.User;
import com.hengfeng.web.utils.ApiResponse;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/user")
	@ResponseBody
	public ApiResponse home()
	{
		User user = userService.selectById(1);
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
		user.setUsername(username);;
		user.setEmail(email);
		return userService.setUserInfo(user);
	}
}
