package com.hengfeng.web.service;

import java.util.List;

import com.hengfeng.web.search.JobSearch;
import com.hengfeng.web.table.JobInfo;

public interface JobInfoService {

	public List<JobInfo> selectJobList(JobSearch jobSearch);
}
