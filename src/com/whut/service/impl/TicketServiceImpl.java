package com.whut.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.TicketDao;
import com.whut.entity.SeatStatic;
import com.whut.entity.Ticket;
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
	public List<SeatStatic> listSeatStaticBySeatLevel(int seatLevel) {
		// TODO Auto-generated method stub
		return dao.listSeatStaticBySeatLevel(seatLevel);
	}

}
