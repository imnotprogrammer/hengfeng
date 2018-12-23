package com.hengfeng.web.service;

import java.util.List;

import com.hengfeng.web.search.JobSearch;
import com.hengfeng.web.table.JobInfo;
import com.hengfeng.web.utils.BusinessException;

public interface JobInfoService {

	public List<JobInfo> selectJobList(JobSearch jobSearch);
	
	public JobInfo selectJobById(Integer id);

	public JobInfo addJobInfo(JobInfo jobInfo) throws BusinessException;
}
