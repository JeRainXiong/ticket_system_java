package com.whut.dao;

import java.util.List;
import java.util.Map;

import com.whut.entity.SeatStatic;
import com.whut.entity.Ticket;

public interface TicketDao {
	public List<Ticket> listAll();
	public List<Ticket> listPage(Map map);
	public int count();//统计总条数
	public Ticket getById(int ticketId);
	public int insert(Ticket ticket);
	public int update(Ticket ticket);
	public int deleteById(int ticketId);
	
	
	public List<SeatStatic> listSeatStaticBySeatLevel(int seatLevel);
	//public List<Seat>;
}
