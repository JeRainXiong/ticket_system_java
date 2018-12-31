package com.whut.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * 基层控制器，所有控制器继承此控制器
 * @author 熊泽雨
 *
 */
public class BaseController {
	@Autowired  
	private  HttpServletRequest request;  
	
	
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
 * @param message
 * @param jumpUrl
 * @param waitTime
 * @return
 */
    protected String showMessage(String message, String jumpUrl,int waitTime)
    {     
    	if(jumpUrl==null || jumpUrl.equals(""))
    		jumpUrl = "javascript:history.back();";
    	

        String script = "<script>setTimeout(function(){location.href = '" + jumpUrl+ "'},"+waitTime+"*1000);</script>";
        String html = "<b>" + message + "</b></br>"+
            "不想等待，<a href = '"+ jumpUrl +"'>点击这里</a>";
        return script+html;

    }
}
