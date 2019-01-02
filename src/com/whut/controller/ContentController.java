package com.whut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.Concert;
import com.whut.entity.TicketType;
import com.whut.service.impl.ConcertServiceImpl;
import com.whut.service.impl.TicketServiceImpl;

@Controller
public class ContentController extends BaseController {
	@Autowired
	ConcertServiceImpl concertServiceImpl;
	@Autowired
	TicketServiceImpl ticketServiceImpl;
	
	@RequestMapping("/content")
    public ModelAndView content(int concertId,Model model){     
	   
	   
	   Concert thisConcert = concertServiceImpl.getById(concertId);
	   List<TicketType> ticketTypeList= new ArrayList<TicketType>();
	   ticketTypeList=ticketServiceImpl.getTicketTypeListByConcert(concertId);
//       System.out.println("100"+ticketTypeList);
	   if(thisConcert==null)
		   showMessage("未查询到该演唱会","/index",2);
	   model.addAttribute("ticketTypeList",ticketTypeList);
	   model.addAttribute("concert", thisConcert);
       return new ModelAndView("content");
    }
	
	
}
