package com.hengfeng.web.controller.admin;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengfeng.web.controller.BaseController;
import com.hengfeng.web.search.JobSearch;
import com.hengfeng.web.service.JobInfoService;
import com.hengfeng.web.table.JobInfo;
import com.hengfeng.web.utils.ApiResponse;

@Controller
public class JobController extends BaseController {

	//@Resource
	private JobInfoService jobService;
	
	@RequestMapping(value = "/job/index", method = RequestMethod.GET)
	@ResponseBody
	public ApiResponse index(@RequestParam(value = "start_created_at", required = false) Date start_created_at,
			@RequestParam(value = "end_created_at", required = false) Date end_created_at,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "unit_name", required = false) String unit_name,
			@RequestParam(value = "salary_type", required = false, defaultValue = "0") String salary_type,
			@RequestParam(value = "status", required = false, defaultValue = "0") String status,
			@RequestParam(value = "sort", required = false) String sort) 
	{
		JobSearch jobSearch = new JobSearch();
		
		jobSearch.setEnd_created_at(end_created_at);
		jobSearch.setSalary_type(Integer.valueOf(salary_type));
		jobSearch.setStart_created_at(start_created_at);
		jobSearch.setSort(sort);
		jobSearch.setTitle(title);
		jobSearch.setUnit_name(unit_name);
		jobSearch.setStatus(Byte.valueOf(status));
		
		List<JobInfo> jobList = jobService.selectJobList(jobSearch);
		
		return ApiResponse.createResponse(jobList);
	}
}
