package com.whut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.Concert;

import com.whut.service.impl.ConcertServiceImpl;
import com.whut.service.impl.OrderServiceImpl;
import com.whut.service.impl.UserServiceImpl;

@Controller//测试用控制器
public class TestController extends BaseController{
	@Autowired
	UserServiceImpl serviceU;
	
	@Autowired
	OrderServiceImpl serviceO;
	
	@Autowired
	ConcertServiceImpl serviceC;
	
//	@RequestMapping("test")
//	public ModelAndView test(Model model){     
//		   System.out.println("succffffff");
//		   //在这调用服务
//		   //model为传到前端页面的参数
//		   List<User> variable = serviceU.listAll();
//		   
//		   System.out.println(variable);
//		   model.addAttribute("variableName", variable);
//	       return new ModelAndView("test");
//	    }
	
	//��id����
//	@RequestMapping("test")
//	public ModelAndView select(Model model) {
//		System.out.println("seeeeeeeee");
//		User user = serviceU.getById(11);
//		System.out.println(user.getUserId());
//		model.addAttribute("user", user);
//
//		return new ModelAndView("test");
//	}
	
	//�����ֲ���
//	@RequestMapping("test")
//	public ModelAndView select(Model model) {
//		System.out.println("**************");
//		User user = serviceU.getByUsername("testUser");
//		System.out.println(user.getUserId());
//		model.addAttribute("user", user);
//
//		return new ModelAndView("test");
//	}
	
//	@RequestMapping("test")
//	public ModelAndView insert(Model model) {
//		System.out.println("**************");
//		User user = new User("xiaoming","121212","xiaohong","777777","88888888");
//		serviceU.insert(user);
//		System.out.println(user.toString());
//		model.addAttribute("user", user);
//
//		return new ModelAndView("test");
//	}
	
	
	//order����
//	@RequestMapping("test")
//	public ModelAndView insert(Model model) {
//		System.out.println("**************");
//		Order order = new Order(2);
//		serviceO.insert(order);
//		System.out.println(order.toString());
//		model.addAttribute("order", order);
//
//		return new ModelAndView("test");
//	}
	
	
	//concert�ؼ��ֲ���
	@RequestMapping("test")
	public ModelAndView insert(Model model) {
		System.out.println("**************");
		List<Concert> list = new ArrayList<Concert>();
		list = serviceC.listByName("�Ϻ�");
		System.out.println("-------------------");
		model.addAttribute("concerts", list);

		return new ModelAndView("test");
	}
	@RequestMapping("test/jsontest")
	@ResponseBody
	public String jsontest() {
		System.out.println(isLogin());
		return success("����",null,2000);
	}
}

