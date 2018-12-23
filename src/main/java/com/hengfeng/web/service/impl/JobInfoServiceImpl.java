package com.hengfeng.web.service.impl;

import java.util.Date;
import java.util.List;
import com.hengfeng.web.utils.BusinessException;
import com.hengfeng.web.utils.ErrorBusinessEnum;
import com.hengfeng.web.utils.validator.ValidatorImpl;
import com.hengfeng.web.utils.validator.ValidtorResult;
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

	@Autowired
	private ValidatorImpl validator;
	
	@Override
	public List<JobInfo> selectJobList(JobSearch jobSearch) {
	
		return jobInfoDao.selectJobList(jobSearch);
	}

	@Override
	public JobInfo selectJobById(Integer id) {
		// TODO Auto-generated method stub
		return jobInfoDao.selectByPrimaryKey(id);
	}
	@Override
	public JobInfo addJobInfo(JobInfo jobInfo) throws BusinessException
	{
		System.out.println(jobInfo.toString());
		if (jobInfo == null) {
			throw new BusinessException(ErrorBusinessEnum.UNKOWN_ERROR);
		}
		ValidtorResult validtorResult = validator.validate(jobInfo);
		if (validtorResult.hasError()) {
			String errMessage = validtorResult.getErrMessage();
			throw new BusinessException(ErrorBusinessEnum.PARAMETER_VALIDATE_ERROR, errMessage);
		}
		Date date = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Byte status = 0;
		jobInfo.setStatus(status);
		jobInfo.setCreated_at(date);
		jobInfo.setUpdated_at(date);

		jobInfoDao.insertSelective(jobInfo);
		return jobInfo;
	}
}
