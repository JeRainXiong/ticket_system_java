package com.whut.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.Concert;
import com.whut.entity.Order;
import com.whut.entity.Ticket;
import com.whut.entity.TicketType;
import com.whut.entity.User;
import com.whut.service.impl.ConcertServiceImpl;
import com.whut.service.impl.OrderServiceImpl;
import com.whut.service.impl.TicketTypeServiceImpl;
import com.whut.service.impl.UserServiceImpl;

/**
 * 购买控制类
 * @author YJ
 *
 */
@Controller
@RequestMapping("/buy")
public class BuyController extends BaseController{
	
	@Autowired
	UserServiceImpl serviceU;
	
	@Autowired
	OrderServiceImpl serviceO;
	
	@Autowired
	TicketTypeServiceImpl serviceTy;
	
	@Autowired
	ConcertServiceImpl serviceC;
	
	@Autowired  
	private  HttpServletRequest request; 
	
	
	@RequestMapping("/order")
	@ResponseBody
	public ModelAndView order(int concert_id, int ticket_type_id,Model model) {
		Concert concert = serviceC.getById(concert_id);

		if(concert == null)
			return showMessage("未查询到该演唱会",model);
		
		TicketType ticketType = serviceTy.getByTypeId(ticket_type_id);
		if(ticketType == null)
			return showMessage("未查询到该票", model);
		
		model.addAttribute("concertId", concert.getConcertId());
		model.addAttribute("ticketTypeId", ticketType.getTicketTypeId());
		model.addAttribute("concert", concert);
		
		model.addAttribute("ticketMoney", ticketType.getUnitPrice());
		model.addAttribute("concertAddr", concert.getConcertAddr());
		model.addAttribute("concertTime", concert.getConcertTime());
		model.addAttribute("totalMoney", ticketType.getUnitPrice());
		
		return new ModelAndView("buy/order");
	}
	
	@RequestMapping("/makeorder")
	@ResponseBody
	public String makeorder(int concert_id,int ticket_type_id,String name,String tel,String id_card) {
		
		if(concert_id==0 || ticket_type_id==0 || name==null || tel==null || id_card==null) {
			return error("参数不全", null , 2003);
		}
		
		//判断有无此票
		TicketType ticketType = serviceTy.getByTypeId(ticket_type_id);
		if(ticketType == null)
			return error("无此票",null,2001);
		
		//判断余票
		if(ticketType.getRestNum() <= 0)
			return error("余票不足",null,2002);
		
		//计算总价
		float totalMoney = ticketType.getUnitPrice();
		//获取当前时间
		Date createTime = new Date();
		Date finishTime = new Date();
		
		User user = (User) request.getSession().getAttribute("user");
		
		Concert concert = serviceC.getById(concert_id);
		Ticket ticket = new Ticket(0,0,0,ticket_type_id,concert_id,concert.getConcertName(),concert.getConcertTime(),
				concert.getConcertAddr(),user.getUserId(),id_card,name,createTime,null,null,1);
		
		Order order = new Order(0,user.getUserId(),concert_id,ticket.getTicketId(),ticket_type_id,user.getUserRealname(),id_card,
				tel,totalMoney,1,createTime,finishTime,1,null);
		
		serviceO.insert(order);
		
		if(order.getOrderId() != 0) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("orderId",order.getOrderId());
			map.put("userId", user.getUserId());
			map.put("amount", order.getAmount());
			map.put("redirectURL", "/buy/pay?order_id="+String.valueOf(order.getOrderId()));
			
			return success("创建订单成功",map,2000);
			
		}
		else
			return error("创建失败",null,2003);
	}
	
	
	@RequestMapping("/pay")
	@ResponseBody
	public ModelAndView pay(int order_id,int ticket_type_id, Model model) {
		
		if(order_id == 0)
			return showMessage("无信息",model);
		
		Order order = serviceO.getById(order_id);
		if(order == null)
			return showMessage("未查询到该订单",model);
		
		if(order.getOrderId() == order_id)
			return showMessage("没有权限",model);
		
		if(order.getOrderState() == 1)
			return showMessage("此订单已经成功付款！",model);
		
		if(order.getOrderState() == 2)
			return showMessage("此订单已关闭",model);
		
		TicketType ticketType = serviceTy.getByTypeId(ticket_type_id);
		model.addAttribute("totalMoney", order.getAmount());
		model.addAttribute("name",order.getAmount());
		model.addAttribute("tel", order.getTel());
		
		return new ModelAndView("buy/pay");
		
	}
	
	

}
