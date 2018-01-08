package com.jmu.bibasedmanage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
    
    /**
     * 
     * 日期转换
     * @author zhangqijian
     * @param binder
     * <pre>
     * 修改时间	修改人	修改原因
     * 2017-12-7  zhangqijian 新建
     * </pre>
     */
    @InitBinder  
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }
}
