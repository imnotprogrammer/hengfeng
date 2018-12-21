package com.hengfeng.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengfeng.web.dao.JobInfoDao;
import com.hengfeng.web.search.JobSearch;
import com.hengfeng.web.service.JobInfoService;
import com.hengfeng.web.table.JobInfo;

@Service("JobInfoService")
public class JobInfoServiceImpl implements JobInfoService{

	@Autowired
	private JobInfoDao jobInfoDao;
	
	@Override
	public List<JobInfo> selectJobList(JobSearch jobSearch) {
	
		return jobInfoDao.selectJobList(jobSearch);
	}

	@Override
	public JobInfo selectJobById(Integer id) {
		// TODO Auto-generated method stub
		return jobInfoDao.selectByPrimaryKey(id);
	}

}
