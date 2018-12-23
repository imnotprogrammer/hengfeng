package com.hengfeng.web.service.model;

import java.util.Date;

public class JobInfoModel {
    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date created_at;

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
     * 岗位说明
     */
    private String desc;


}
