package com.hengfeng.web.dao;

import java.util.List;

import com.hengfeng.web.search.JobSearch;
import com.hengfeng.web.table.JobInfo;

public interface JobInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(JobInfo record);

    int insertSelective(JobInfo record);

    JobInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobInfo record);

    int updateByPrimaryKeyWithBLOBs(JobInfo record);

    int updateByPrimaryKey(JobInfo record);
    
    List<JobInfo> selectJob(JobSearch jobSearch);
}