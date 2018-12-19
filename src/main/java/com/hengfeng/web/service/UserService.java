package com.hengfeng.web.service;

import com.hengfeng.web.table.User;

public interface UserService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User selectById(Integer id);
	public int setUserInfo(User user);
}
