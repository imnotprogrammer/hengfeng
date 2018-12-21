package com.hengfeng.web.controller.admin;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hengfeng.web.controller.BaseController;
import com.hengfeng.web.search.JobSearch;
import com.hengfeng.web.service.JobInfoService;
import com.hengfeng.web.table.JobInfo;
import com.hengfeng.web.utils.ApiResponse;
import com.hengfeng.web.utils.BusinessException;
import com.hengfeng.web.utils.ErrorBusinessEnum;

@Controller
public class JobController extends BaseController {

	@Resource
	private JobInfoService jobService;
	
	@RequestMapping(value = "/job/index", method = RequestMethod.GET)
	@ResponseBody
	public ApiResponse index(JobSearch jobSearch) 
	{
		Object obj = jobSearch.setDefautValues();
		if (obj instanceof String) {
			return ApiResponse.createResponse(obj, "fail");
		}
		JobSearch job = (JobSearch) obj;
		List<JobInfo> jobList = jobService.selectJobList(job);
		return ApiResponse.createResponse(jobList);
	}
	@RequestMapping(value = "/job/details", method = RequestMethod.GET)
	@ResponseBody
	public ApiResponse showDetails(@RequestParam(value="id")  Integer id ) throws BusinessException
	{
		
		if (id == null) {
			throw new BusinessException(ErrorBusinessEnum.PARAMETER_VALIDATE_ERROR, "请上传工作信息id");
		}
		
		JobInfo jobInfo = jobService.selectJobById(id);
		
		if (jobInfo == null) {
			throw new BusinessException(ErrorBusinessEnum.PARAMETER_VALIDATE_ERROR, "工作信息不存在");
		}
		
		return ApiResponse.createResponse(jobInfo);
	}
}
