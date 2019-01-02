package com.whut.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.Concert;
import com.whut.service.impl.ConcertServiceImpl;


/**
 * 
 * @author 熊泽雨
 *
 */
@Controller
public class IndexController extends BaseController {
	@Autowired
	ConcertServiceImpl serviceC;	
	
	@RequestMapping("/index")
	public ModelAndView hello(Model model){     
		List<Concert> list = new ArrayList<Concert>();

		list = serviceC.listPage(1,8);

		model.addAttribute("concertList",list);
		model.addAttribute("title","票务系统");
	    return new ModelAndView("index");
	}
	
}
