package com.hengfeng.web.search;

import java.io.Serializable;
import java.util.Date;

/**
 * job_info
 * @author 
 */
public class JobSearch implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date start_created_at;

    /**
     * 创建时间
     */
    private String unit_name;

    /**
     * 薪资级别
     */
    private Integer salary_type;

    /**
     * 0 上线 1 下线
     */
    private Byte status;
    /**
     * 创建时间急速
     */
    private Date end_created_at;
    /**
     * 排序方式
     */
    private String sort = "desc";


    private static final long serialVersionUID = 1L;



    public Date getStart_created_at() {
		return start_created_at;
	}

	public void setStart_created_at(Date start_created_at) {
		this.start_created_at = start_created_at;
	}

	public Date getEnd_created_at() {
		return end_created_at;
	}

	public void setEnd_created_at(Date end_created_at) {
		this.end_created_at = end_created_at;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public Integer getSalary_type() {
        return salary_type;
    }

    public void setSalary_type(Integer salary_type) {
        this.salary_type = salary_type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

}