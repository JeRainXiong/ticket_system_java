package com.whut.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public ModelAndView content(int concertId, Model model) {

        Concert thisConcert = concertServiceImpl.getById(concertId);
        // 修改日期显示格式
        Date date = thisConcert.getConcertTime();
        String pattern = "yyyy-MM-dd HH-mm-ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String datestr = sdf.format(date);// format 为格式化方法

        List<TicketType> ticketTypeList = new ArrayList<TicketType>();
        ticketTypeList = ticketServiceImpl.getTicketTypeListByConcert(concertId);
        // System.out.println("100"+ticketTypeList);
        if (thisConcert == null)
            return showMessage("未查询到该演唱会", model);
        model.addAttribute("ticketTypeList", ticketTypeList);
        // System.out.println(ticketTypeList);
        model.addAttribute("concert", thisConcert);
        model.addAttribute("concertTime", datestr);
        model.addAttribute("title", thisConcert.getConcertName());
        return new ModelAndView("content");
    }

}
