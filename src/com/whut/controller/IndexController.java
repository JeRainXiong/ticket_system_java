package com.whut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends BaseController {
	
	   @RequestMapping("/index")
	    public ModelAndView hello(Model model){     
		   System.out.println("succ");
		   
	        return new ModelAndView("index");
	    }
}
