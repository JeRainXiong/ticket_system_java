package com.whut.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.whut.dao.SeatStaticDao;
import com.whut.dao.TicketDao;
import com.whut.dao.TicketTypeDao;
import com.whut.entity.SeatStatic;
import com.whut.entity.Ticket;
import com.whut.entity.TicketType;
import com.whut.service.TicketService;
@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketDao dao;
    @Autowired
    SeatStaticDao seatStaticDao;	
    @Autowired
    TicketTypeDao ticketTypeDao;    
	@Override
	public List<Ticket> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<Ticket> listPage(Map map) {
		// TODO Auto-generated method stub
		return dao.listPage(map);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public Ticket getById(int ticketId) {
		// TODO Auto-generated method stub
		return dao.getById(ticketId);
	}

	@Override
	public int insert(Ticket ticket) {
		// TODO Auto-generated method stub
		return dao.insert(ticket);
	}

	@Override
	public int update(Ticket ticket) {
		// TODO Auto-generated method stub
		return dao.update(ticket);
	}

	@Override
	public int deleteById(int ticketId) {
		// TODO Auto-generated method stub
		return dao.deleteById(ticketId);
	}
	
	@Override
	public List<TicketType> getTicketTypeListByConcert(int concertId){
		return dao.getTicketTypeListByConcert(concertId);
	}

	@Override
	public List<SeatStatic> listSeatStaticBySeatLevel(int seatLevel) {
		// TODO Auto-generated method stub
		return dao.listSeatStaticBySeatLevel(seatLevel);
	}
    /**
     * 生成随机座位号
     * @author 熊泽雨
     * @param 票具体类型
     */
    @Override
    public SeatStatic getRandomSeat(int ticketTypeId) {
  
        if(ticketTypeId==0) return null;
        TicketType ticketType = ticketTypeDao.getByTypeId(ticketTypeId);
        
        //$condition = empty($seat_level) ? []:['seat_level'=>$seat_level];
        List<SeatStatic> seat_static_list = seatStaticDao.listBySeatLevel(ticketType.getSeatLevel());
        //所有符合当前票价的座位
        if(seat_static_list.isEmpty()) return null;
        

        //已被选择的座位
        Map map = new HashMap();
        map.put("ticketTypeId",ticketTypeId);

        List<Ticket> ticket_list = dao.listChoosen(map);
        
        
        //去除被选的座位
            for (Ticket ticket : ticket_list) {
                   seat_static_list.remove(ticket.getSeatStaticId()-1);
            }
        Random r =new Random();
        
        return seat_static_list.isEmpty()? null:seat_static_list.get(r.nextInt(seat_static_list.size()));
    }

    @Override
    public SeatStatic getSeatStaticById(int id) {
        
        return seatStaticDao.getById(id);
    }

    @Override
    public String createTicketQrString(Ticket ticket) {
        Map<String,Object> map = new HashMap<String,Object>();
        //加密处理
/*        map.put("ticketId", ticket.getTicketId());
        map.put("seatStaticId", ticket.getSeatStaticId());
        map.put("ticketTypeId", ticket.getTicketTypeId());
        map.put("createTime", ticket.getCreateTime().toString());*/
        map.put("tt", ticket.getTicketId());
        map.put("cc", ticket.getSeatStaticId());
        map.put("cr", ticket.getTicketTypeId());
        //map.put("kf", ticket.getCreateTime().toString());
        
        String qrString =  JSON.toJSONString(map);
        return qrString;
    }

    public List<Ticket> listByOrderId(int orderId) {
        return dao.listByOrderId(orderId);
    }

}
