package com.whut.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.TicketDao;
import com.whut.entity.SeatStatic;
import com.whut.entity.Ticket;
import com.whut.entity.TicketType;
import com.whut.service.TicketService;
@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketDao dao;
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
        $md = new TicketModel();
        $condition = empty($seat_level) ? []:['seat_level'=>$seat_level];
        $seat_static_list = $md->getSeatStaticList($condition);
        if(empty($seat_static_list)) return false;
        
        $condition['concert_id']=$concert_id;
        $condition['seat_state']=1;
        $seat_list = $md->getSeatList($condition);
        if(!empty($seat_list))
            foreach ($seat_list as $value) {
                    $id = $value['seat_id'];
                    unset($seat_static_list[(int)$id]);                    
            }
        return empty($seat_static_list) ? false:$seat_static_list[array_rand($seat_static_list)];
        return null;
    }

}
