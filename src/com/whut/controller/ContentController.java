package com.whut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController extends BaseController {
	//@Autowired
	//ConcertServiceImpl service;
	
	@RequestMapping("/content")
    public ModelAndView content(int concertId,Model model){     
		
	
	
	   System.out.println("contentId");
	   //Concert concert = service.getById(concertId);
	   
	   //model.addAttribute("concert", concert);
        return new ModelAndView("content");
    }
}
