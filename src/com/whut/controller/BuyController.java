package com.whut.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.whut.entity.TicketType;
import com.whut.entity.User;
import com.whut.service.impl.ConcertServiceImpl;
import com.whut.service.impl.OrderServiceImpl;
import com.whut.service.impl.TicketTypeServiceImpl;
import com.whut.service.impl.UserServiceImpl;
import com.whut.util.MD5;

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
	public ModelAndView order(Integer concert_id, Integer ticket_type_id,Model model) {
        if(!isLogin())return showMessage("登陆后操作");
	    
	    if(concert_id==null||ticket_type_id==null)
        {
            return showMessage("错误参数");
        }	    
	    
		Concert concert = serviceC.getById(concert_id);
		if(concert == null)
			return showMessage("未查询到该演唱会",model);
		
		TicketType ticketType = serviceTy.getByTypeId(ticket_type_id);
		if(ticketType == null)
			return showMessage("未查询到该票", model);
		DecimalFormat  df1 = new DecimalFormat ("####.00"); 
		

		model.addAttribute("ticketTypeId", ticketType.getTicketTypeId());
		model.addAttribute("concert", concert);
		
		model.addAttribute("ticketMoney", df1.format(ticketType.getUnitPrice()));
		model.addAttribute("totalMoney", ticketType.getUnitPrice());
		model.addAttribute("title", "订单填写");
		return new ModelAndView("buy/order");
	}
	
	@RequestMapping("/makeorder")
	@ResponseBody
	public String makeorder(int concert_id,int ticket_type_id,String name,String tel,String id_card) {
	    if(!isLogin())return error("登陆后操作",null,2888);
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
		
		User user = this._login_user;
		
		Concert concert = serviceC.getById(concert_id);
		//Ticket ticket = new Ticket(0,0,0,ticket_type_id,concert_id,concert.getConcertName(),concert.getConcertTime(),
		//		concert.getConcertAddr(),user.getUserId(),id_card,name,createTime,null,null,1);
		
		Order order = new Order(0,user.getUserId(),concert_id,0,ticket_type_id,user.getUserRealname(),id_card,
				tel,totalMoney,0,createTime,finishTime,0,null);
		
		serviceO.createOrder(order);
		
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
	public ModelAndView pay(int order_id, Model model) {
	    if(!isLogin())return showMessage("登陆后操作");
		if(order_id == 0)
			return showMessage("无信息",model);
		
		Order order = serviceO.getById(order_id);
		if(order == null)
			return showMessage("未查询到该订单",model);
		
		if(order.getUserId() !=this._login_user.getUserId())
			return showMessage("没有权限",model);
		
		if(order.getOrderState() == 1)
			return showMessage("此订单已经成功付款！",model);
		
		if(order.getOrderState() == 2)
			return showMessage("此订单已关闭",model);
		
		TicketType ticketType = serviceTy.getByTypeId(order.getTicketTypeId());
		
		//随机生成TOKEN
		//写入order存入Session中，防止调用，付款时检查session
		String token = MD5.md5(((new Date()).toString()));
		order.setOrderToken(token);
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		request.getSession().setAttribute("orderList", orderList);
		
		String pay_url = "/buy/dopay?order_id="+String.valueOf(order.getOrderId())
		    +"&token="+token;
		System.out.println(ticketType);
		model.addAttribute("order", order);
		model.addAttribute("ticketType", ticketType);
		model.addAttribute("title", "付款");
		model.addAttribute("pay_url", pay_url);
		return new ModelAndView("buy/pay");
		
	}
	
	

}
