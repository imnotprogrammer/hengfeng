package com.hengfeng.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengfeng.web.dao.UserDao;
import com.hengfeng.web.service.UserService;
import com.hengfeng.web.table.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User selectById(Integer id){
		return userDao.selectByPrimaryKey(id);
	}
	public int setUserInfo(User user)
	{
		return userDao.updateByPrimaryKeySelective(user);
	}
}
