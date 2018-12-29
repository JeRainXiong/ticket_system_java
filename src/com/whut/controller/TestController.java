package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.User;
import com.whut.service.impl.UserServiceImpl;

@Controller//测试用控制器
public class TestController {
	@Autowired
	UserServiceImpl serviceU;
	@RequestMapping("test")
	
	public ModelAndView test(Model model){     
		   System.out.println("succffffff");
		   //在这调用服务
		   //model为传到前端页面的参数
		   List<User> variable = serviceU.listAll();
		   
		   System.out.println(variable);
		   model.addAttribute("variableName", variable);
	       return new ModelAndView("test");
	    }
}
