package com.whut.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.Order;
import com.whut.service.impl.OrderServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController { 
    @Autowired
    OrderServiceImpl ServiceO;
    
    protected HashMap<String,String> _state = new HashMap<String, String>(){
        {
        put("0", "待付款");
        put("1", "已完成");
        put("2", "已关闭");
        put("3", "已退款");
        }
    };
    
    
 
 

    /**
     * 初始化
     * @param model
     */
    @ModelAttribute
    public void init(Model model) {
        super.init(model);
        if(!isLogin()){
            showMessage("用户未登录","/index",3);
            return;   
        }

    }  
    /**
     * 个人订单详情页
     * @param model
     * @return
     */
    @RequestMapping("/order")
    public ModelAndView order(Model model){     
        List<Order> list = new ArrayList<Order>();

        //list = ServiceO

        model.addAttribute("orderList",list);
        model.addAttribute("title","我的订单");
        model.addAttribute("state",_state);
        return new ModelAndView("account/order");
    }
    
 
}
