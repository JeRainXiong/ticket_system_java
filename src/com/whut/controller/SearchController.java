package com.whut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.Concert;
import com.whut.service.impl.ConcertServiceImpl;

@Controller
public class SearchController extends BaseController {
	@Autowired
	ConcertServiceImpl serviceC;
	
	@RequestMapping("/search")
    public ModelAndView content(String key_word,Model model){     
		
		
		
	  // System.out.println("contentId");
	   List<Concert> concert = serviceC.listByName(key_word);
	   
	   model.addAttribute("concertList", concert);
        return new ModelAndView("search");
    }
}
