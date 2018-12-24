package com.hengfeng.web.controller.admin;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hengfeng.web.search.JobSearch;
import com.hengfeng.web.service.JobInfoService;
import com.hengfeng.web.table.JobInfo;
import com.hengfeng.web.utils.ApiResponse;
import com.hengfeng.web.utils.BusinessException;
import com.hengfeng.web.utils.ErrorBusinessEnum;

@Controller
public class JobController extends BaseController {

	private String prefix = "/admin/job/";
	@Resource
	private JobInfoService jobService;
	
	@RequestMapping(value = "/admin/job/listData", method = RequestMethod.GET)
	@ResponseBody
	public ApiResponse index(JobSearch jobSearch)
	{
		PageHelper.startPage(jobSearch.getPage(), jobSearch.getPagesize());
		Object obj = jobSearch.setDefautValues();
		if (obj instanceof String) {
			return ApiResponse.createResponse(obj, "fail");
		}
		JobSearch job = (JobSearch) obj;
		PageInfo<JobInfo> jobList = new PageInfo<>(jobService.selectJobList(job));
		for (JobInfo jobInfo:jobList.getList()) {
		}
		return ApiResponse.createResponse(jobList);
	}
	@RequestMapping(value = "/admin/job/index", method = RequestMethod.GET)
	public String  index()
	{
		return prefix + "joblist";
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
	@RequestMapping(value = "/admin/job/add", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse add(@RequestParam(name = "title", defaultValue = "")String title,
						   @RequestParam(name = "unit_name", defaultValue = "")String unit_name,
						   @RequestParam(name = "salary_type", defaultValue = "")Integer salary_type,
						   @RequestParam(name = "desc", defaultValue = "")String desc) throws BusinessException
	{
		JobInfo jobInfo = new JobInfo();
		jobInfo.setSalary_type(salary_type);
		jobInfo.setTitle(title);
		jobInfo.setUnit_name(unit_name);
		jobInfo.setDesc(desc);
		return ApiResponse.createResponse(jobService.addJobInfo(jobInfo));
	}
	@RequestMapping(value = "/admin/job/add", method = RequestMethod.GET)
	public String addjob(@PathVariable Integer id, Model model)
	{
		//jobInfo = jobService.addJobInfo(jobInfo);
		if (id != null) {
			JobInfo job = jobService.selectJobById(id);
			model.addAttribute("job", job);
		}
		return prefix + "addjob";
	}
}
