package com.whut.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.entity.User;
import com.whut.service.impl.UserServiceImpl;

/**
 * 
 * @author 熊泽雨
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
	UserServiceImpl serviceU;
	
	@Autowired  
	private  HttpServletRequest request;  
		
	@RequestMapping("/dologin")	
	@ResponseBody
	public String dologin(String username,String password) {
	

        if(username.equals("") || password.equals("")){
            return error("用户名或密码为空！",null,2001);

        }
        User user = serviceU.getByUsername(username);

        if(user.getPassword().equals(password))
        {
        	request.getSession().setAttribute("user", user);
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.put("username", user.getUsername());
        	map.put("userId",user.getUserId());
        	return success("登陆成功",map,2000);

            
        } else {
            return error("用户名和密码不匹配",null,2002);
        }
		

	}
	
	@RequestMapping("/dologout")	
	@ResponseBody
	public String doLogout() {
		if(request.getSession().getAttribute("user")!=null)
		{
			request.getSession().removeAttribute("user");
		}
		return success("注销成功",null,2000);
	
	}	
}
