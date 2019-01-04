package com.whut.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.OrderDao;
import com.whut.dao.TicketTypeDao;
import com.whut.entity.Concert;
import com.whut.entity.Order;
import com.whut.entity.SeatStatic;
import com.whut.entity.Ticket;
import com.whut.entity.TicketType;
import com.whut.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao dao;
    @Autowired
    TicketServiceImpl ServiceT;
    @Autowired
    ConcertServiceImpl ServiceC;
    @Autowired
    TicketTypeDao ticketTypeDao;
	@Override
	public List<Order> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<Order> listPage(Map map) {
		// TODO Auto-generated method stub
		return dao.listPage(map);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public Order getById(int orderId) {
		// TODO Auto-generated method stub
		return dao.getById(orderId);
	}

	@Override
	public int insert(Order order) {
		// TODO Auto-generated method stub
		return dao.insert(order);
	}

	@Override
	public int update(Order order) {
		// TODO Auto-generated method stub
		return dao.update(order);
	}

	@Override
	public int deleteById(int orderId) {
		// TODO Auto-generated method stub
		return dao.deleteById(orderId);
	}

    @Override
    public List<Order> listByUserId(int userId, int beginPage, int pageRows) {
        // TODO 自动生成的方法存根
        int begin = (beginPage -1)*pageRows;
        Map map = new HashMap();
        map.put("begin", begin);
        map.put("rows", pageRows);
        map.put("userId", userId);
        // TODO Auto-generated method stub
        return dao.listByUserId(map);
    }
/**
 * 创建订单
 */
    @Override
    public boolean createOrder(Order order) {
        if(order == null)return false;
        TicketType ticketType = ticketTypeDao.getByTypeId(order.getTicketTypeId());
        if(ticketType.getRestNum()<=0)return false;
        SeatStatic ss =  ServiceT.getRandomSeat(order.getTicketTypeId());
        if(ss ==null ) return false;
        
        ticketType.setRestNum(ticketType.getRestNum()-1);
        //System.out.println("更新ticketType表");
      //  System.out.println(ticketType);
        if(ticketTypeDao.update(ticketType)==0)return false;//更新失败
      //  System.out.println("插入order");
       
        if(dao.insert(order)==0)return false;
        Concert concert = ServiceC.getById(order.getConcertId());
        //创建临时ticket
        Ticket ticket = new Ticket(0,
                order.getOrderId(),
                ss.getSeatStaticId(),
                order.getTicketTypeId(),
                order.getConcertId(),
                concert.getConcertName(),
                concert.getConcertTime(),
                concert.getConcertAddr(),
                order.getUserId(),
                order.getIdCard(),
                order.getRealname(),
                new Date(),
                0,
                "",
                ""
                );
        
        ticket.setCheckCode(ServiceT.createTicketQrString(ticket));
        if(ServiceT.insert(ticket)==0)return false;
        order.setTicketId(ticket.getTicketId());
        dao.update(order);
        
        
        return true;
    }
    /**
     * 完成订单
     */
        public boolean finishOrder(Order order){
            if(order == null)return false;
            order.setOrderState(1);
            order.setPaymentState(1);
            order.setFinishTime(new Date());
            
            List<Ticket> ticketList = ServiceT.listByOrderId(order.getOrderId());
            for(Ticket t : ticketList) {
                t.setTicketState(1);
                ServiceT.update(t);
            }
            //若更新失败
            if(dao.update(order)==0)return false;
            return true;
        }
}
