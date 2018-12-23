package com.hengfeng.web.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;


@Controller
public class IndexController extends BaseController {
    @GetMapping("/index")
    public String index(HashMap<String, Object> map, @RequestParam(name = "resource", defaultValue = "", required = false) String resource)
    {
        System.out.println(resource);
        map.put("name", "恒丰后台管理系统");
        System.out.println((resource.equals("")) || (resource.isEmpty()));
        if (resource.equals("") || resource.isEmpty()) {
            return "/admin/index";
        } else {
            return "/admin/" + resource;
        }
    }
    @RequestMapping("/welcome")
    public String welcome()
    {
        return "/admin/welcome";
    }
}
