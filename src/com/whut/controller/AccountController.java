package com.whut.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.whut.util.Bean2Map;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController { 
    @Autowired
    OrderServiceImpl ServiceO;
    @Autowired
    ConcertServiceImpl ServiceC;
    @Autowired
    TicketTypeServiceImpl ServiceT;     
    @Autowired
    UserServiceImpl ServiceU;      
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
            showMessage("用户未登录");
            return;
        }
   
    }  
    /**
     * 个人订单页
     * @param model
     * @return
     */
    @RequestMapping("/order")
    public ModelAndView order(Integer page,Model model){  
        if(page==null)page=1;
        User user = this._login_user;
        if(user==null)return new ModelAndView("redirect:/index");
        List<Order> orderList = new ArrayList<Order>();//这个是获取的list
        List<Map> list = new ArrayList<Map>();//这个是传过去的list
        orderList = ServiceO.listByUserId(user.getUserId(), page, 10);//一页十个数据
        
        if(!orderList.isEmpty()){
            for (Order order : orderList) {
                Map<String,Object> orderMap = Bean2Map.bean2map(order);//转map 并插入concert
                Concert concert;
                concert = ServiceC.getById(order.getConcertId());
                //System.out.println(concert);
                orderMap.put("concert",concert);
                list.add(orderMap);
                    
            }
        }
        
        //System.out.println(list);
        model.addAttribute("orderList",list);
        model.addAttribute("title","我的订单");
        model.addAttribute("state",_state);
        return new ModelAndView("account/order");
    }
    /**
     * 订单详情
     * @param model
     * @return
     */
    @RequestMapping("/orderdetail")
    public ModelAndView orderdetail(Integer order_id,Model model){  
        if(this._login_user==null)return this.showMessage("登陆后操作",model);
        if(order_id==null)
            return this.showMessage("无数据",model);
        Order order = ServiceO.getById(order_id);
        if(order==null){
            return this.showMessage("未查询到该订单",model);
        }        
        if(order.getUserId() != this._login_user.getUserId()){
            return this.showMessage("没有权限查看此订单",model);
        }        

        TicketType ticket_type =ServiceT.getByTypeId(order.getTicketTypeId()); 
        Concert concert =ServiceC.getById(order.getConcertId()); 
        if(ticket_type==null|| concert==null){
            return this.showMessage("此订单已无法查看");
        }
        
        Map<String,Object> orderMap = Bean2Map.bean2map(order);//转map 并插入concert

        orderMap.put("concert",concert);
        orderMap.put("ticket_type",ticket_type);


        //System.out.println(list);
        model.addAttribute("order",orderMap);
        model.addAttribute("title","订单详情");
        model.addAttribute("state",_state);
        return new ModelAndView("account/orderdetail");
    }    
    @RequestMapping("/user")
    public ModelAndView user(Model model){ 
        if(this._login_user==null)return this.showMessage("登陆后操作");
        
        model.addAttribute("title","我的信息");     
        return new ModelAndView("account/user");
    }  
    
    @RequestMapping("/changeinfo")
    @ResponseBody
    public String changeinfo(String realname,String tel,String id_card){ 
        if(this._login_user==null)return this.error("登陆后操作",null,1001);
        User u = new User(_login_user);
        if(!realname.isEmpty())
            u.setUserRealname(realname);
        if(!tel.isEmpty())
            u.setTel(tel);
        if(!id_card.isEmpty())
            u.setUserIdCard(id_card);
        
        if(ServiceU.update(u) != 0) {
            this._login_user=u;
            request.getSession().setAttribute("user", u);

            
            return success("修改信息成功",null,2000);
            
        }
        else
            return error("修改失败",null,2003);        

    }  
    @RequestMapping("/changepssword")
    @ResponseBody
    public String changepssword(String old_password,String new_password){ 
        if(this._login_user==null)return this.error("登陆后操作",null,1001);
        if(old_password==null || new_password==null)return this.error("参数错误", null, 1002);
        if(!_login_user.getPassword().equals(old_password))
            return this.error("原密码错误", null, 1003);
        
        User u = new User(_login_user);
        u.setPassword(new_password);
        
        if(ServiceU.update(u) != 0) {
            this._login_user=u;
            request.getSession().setAttribute("user", u);
            return success("修改密码成功",null,2000);
            
        }
        else
            return error("修改失败",null,2003);     
    }  
               
  
}
