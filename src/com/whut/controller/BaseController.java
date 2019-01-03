package com.whut.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.whut.entity.User;

/**
 * 基层控制器，所有控制器继承此控制器
 * @author 熊泽雨
 *
 */
public class BaseController {
	@Autowired  
	protected  HttpServletRequest request;  
    @Autowired  
    protected  HttpServletResponse  response;  	
	//protected List<String> _freeActions = Arrays.asList("index","content","Search","register");   	
    protected User _login_user;
    /**
     * 所有控制器启动前做的事
     * @param model
     */
    @ModelAttribute
    public void init(Model model) {
//      if(isLogin()){
//          model.addAttribute("user",request.getSession().getAttribute("user"));
//        }
        if(isLogin())
            _login_user = (User)request.getSession().getAttribute("user");
        model.addAttribute("title","学霸蟹票务系统");
       ;
    }	
	/**
	 * 判断用户是否登陆
	 * @author 熊泽雨
	 * @return
	 */
    public boolean isLogin() {

    	//HttpSession session= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    	
    	HttpSession session=request.getSession();
        return session.getAttribute("user") != null ? true:false;
    }
    /**
     * 成功提示信息
     * @author 熊泽雨
     * @param msg信息
     * @param map键值对 类似JSON
     * @param code 2000表示成功
     * @return String
     */
    protected String success(String msg, Map<String,Object> data, int code)
    {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put( "code", String.valueOf(code));
    	map.put("msg",msg);
    	map.put("data",data!=null ?data:"");
    
        return    json(map);
    }
    
    /**
     * 失败提示信息
     * @author 熊泽雨
     * @param msg信息
     * @param map键值对 类似JSON
     * @param code 非2000代码
     * @return String
     */
    protected String error(String msg, Map<String,Object> data, int code)
    {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put( "code", String.valueOf(code));
    	map.put("msg",msg);
    	map.put("data", data!=null ?data:"");
        
        return json(map);
    }
    
    /**
     * 返回JSON数据到ResponseBody
     * @author 熊泽雨
     * @param json
     * @return
     */
    @ResponseBody
    protected String json(Map<String,Object> json)
    {
    	String mapJsonString = JSON.toJSONString(json);
    	//System.out.println(mapJsonString);
        return mapJsonString;
    }
    
/**
 * 提示信息
 * @author 熊泽雨    
 * @param message 错误信息
 * @return
 */
    protected ModelAndView showMessage(String message, Model model)
    {     
/*    	if(jumpUrl==null || jumpUrl.equals(""))
    		jumpUrl = "javascript:history.back();";
    	

        String script = "<script>setTimeout(function(){location.href = '" + jumpUrl+ "'},"+waitTime+"*1000);</script>";
        String html = "<b>" + message + "</b></br>"+
            "不想等待，<a href = '"+ jumpUrl +"'>点击这里</a>";*/
        System.out.println(message);
        model.addAttribute("message", message);
        return new ModelAndView("error");

    }
/*    @ResponseBody
    protected String showMessage(String message)
    {     
        String jumpUrl = "javascript:history.back();";
        String script = "<script>setTimeout(function(){location.href = '" + jumpUrl+ "'},3000);</script>";
        String html = "<b>" + message + "</b></br>"+
            "不想等待，<a href = '"+ jumpUrl +"'>点击这里</a>";
        return script+html;
        

    }*/
    /**
     * 提示信息
     * @author 熊泽雨    
     * @param message 错误信息
     * @return
     */
        protected ModelAndView showMessage(String message)
        {    
            ModelAndView mav = new ModelAndView("error"); 
            mav.addObject("message", message);
            System.out.println(message);
            return mav;

        }
}
