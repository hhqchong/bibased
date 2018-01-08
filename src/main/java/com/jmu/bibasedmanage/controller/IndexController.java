package com.jmu.bibasedmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ljc on 2018/1/3.
 */
@Controller
public class IndexController {
    /**
     * 首页框架
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "/index/index.html";
    }
    @RequestMapping("/main.html")
    public String main(){
        return "/index/main.html";
    }
    @RequestMapping("/table.html")
    public String table(){
        return "/index/table.html";
    }
}
