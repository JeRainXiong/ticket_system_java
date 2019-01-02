package com.whut.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whut.entity.Concert;
import com.whut.entity.Order;
import com.whut.entity.User;
import com.whut.service.impl.ConcertServiceImpl;
import com.whut.service.impl.OrderServiceImpl;
import com.whut.util.Bean2Map;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController { 
    @Autowired
    OrderServiceImpl ServiceO;
    @Autowired
    ConcertServiceImpl ServiceC;
        
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
            try {
                response.sendRedirect("/index");
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
 
  
        }
   
    }  
    /**
     * 个人订单详情页
     * @param model
     * @return
     */
    @RequestMapping("/order")
    public ModelAndView order(Integer page,Model model){  
        if(page==null)page=1;
        User user = this._login_user;
        if(user==null)return new ModelAndView("redirect:index");
        List<Order> orderList = new ArrayList<Order>();//这个是获取的list
        List<Map> list = new ArrayList<Map>();//这个是传过去的list
        orderList = ServiceO.listByUserId(user.getUserId(), page, 10);//一页十个数据
        
        if(!orderList.isEmpty()){
            for (Order order : orderList) {
                Map<String,Object> orderMap = Bean2Map.bean2map(order);//转map 并插入concert
                Concert concert;
                concert = ServiceC.getById(order.getConcertId());
                System.out.println(concert);
                orderMap.put("concert",concert);
                list.add(orderMap);
                    
            }
        }
        
        System.out.println(list);
        model.addAttribute("orderList",list);
        model.addAttribute("title","我的订单");
        model.addAttribute("state",_state);
        return new ModelAndView("account/order");
    }
    
 
}
