package com.hengfeng.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/system")
public class SystemController extends BaseController{
    private String prefix = "/admin/website";
    @RequestMapping("/set")
    public String setPage()
    {
        return prefix + "/set";
    }

    /**
     * 数据字典
     * @return
     */
    @RequestMapping("/data")
    public String setData()
    {
        return prefix + "/data";
    }
    /**
     * 系统日志
     * @return
     */
    @RequestMapping("/log")
    public String log()
    {
        return prefix + "/log";
    }
}
