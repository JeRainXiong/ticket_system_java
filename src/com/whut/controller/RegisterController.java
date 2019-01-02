package com.whut.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.User;
import com.whut.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController{
	@Autowired
	UserServiceImpl serviceU;
	
	@Autowired  
	private  HttpServletRequest request; 
	
	@RequestMapping("/doregister")
	@ResponseBody
	public String doRegister(String username, String password) {
		
		if(username.equals("") || password.equals("")){
            return error("用户名或密码为空！",null,2001);
        }
		
		User u = serviceU.getByUsername(username);
		
		if(u!=null)
			return error("用户名已存在",null,2001);
		
		User user = new User(0,username, password,null,null,null);
		serviceU.insert(user);
		User us = serviceU.getByUsername(username);
			
		if(us!=null) {
			request.getSession().setAttribute("user", user);
		    Map<String,Object> map = new HashMap<String,Object>();
		    map.put("username", user.getUsername());
		    map.put("password",user.getPassword());
		    return success("注册成功",map,2000);
		}
		else
			return error("与服务器连接超时",null,2003);

    }
}
