package com.whut.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.whut.entity.Concert;
import com.whut.entity.SeatStatic;
import com.whut.entity.Ticket;
import com.whut.service.impl.ConcertServiceImpl;
import com.whut.service.impl.TicketServiceImpl;
import com.whut.service.impl.UserServiceImpl;

@Controller

public class TicketController extends BaseController {

    @Autowired
    ConcertServiceImpl ServiceC;
    @Autowired
    TicketServiceImpl ServiceT;
    @Autowired
    UserServiceImpl ServiceU;

    @RequestMapping("/showTicket") // 出票
    public ModelAndView showTicket(int ticketId, Model model) {

        // 判断登录
        if (!isLogin())
            return showMessage("请登录！", model);
        // 非法请求
        Ticket ticket = ServiceT.getById(ticketId);

        if (ticket == null)
            return showMessage("非法请求", model);

        // 没有权限
        if (ticket.getUserId() != _login_user.getUserId())
            return showMessage("没有权限", model);
        // 出票失败
        if (ticket.getCheckCode() == null)
            return showMessage("出票失败", model);
        // 出票成功，根据订单号和票号 打印

        Concert concert = ServiceC.getById(ticket.getConcertId());
        SeatStatic seatStatic  =ServiceT.getSeatStaticById(ticket.getSeatStaticId());
        
        Map<String,Object> map = new HashMap<String,Object>();
        //加密处理
/*        map.put("ticketId", ticket.getTicketId());
        map.put("seatStaticId", ticket.getSeatStaticId());
        map.put("ticketTypeId", ticket.getTicketTypeId());
        map.put("createTime", ticket.getCreateTime().toString());*/
        map.put("tt", ticket.getTicketId());
        map.put("cc", ticket.getSeatStaticId());
        map.put("cr", ticket.getTicketTypeId());
        map.put("kf", ticket.getCreateTime().toString());
        
        String qrString =  JSON.toJSONString(map);
        
        
        model.addAttribute("title", "出票");
        // 二维码 暂时以固定数据代替
        
        
        model.addAttribute("qrString", qrString);
        model.addAttribute("ticket", ticket);
        model.addAttribute("concert", concert);
        model.addAttribute("seatStatic", seatStatic);
        return new ModelAndView("showticket");
    }

}
