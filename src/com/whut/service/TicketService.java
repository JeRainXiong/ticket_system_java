package com.whut.service;

import java.util.List;
import java.util.Map;

import com.whut.entity.SeatStatic;
import com.whut.entity.Ticket;
import com.whut.entity.TicketType;

public interface TicketService {
	public List<Ticket> listAll();
	public List<Ticket> listPage(Map map);
	public int count();//统计总条数
	public Ticket getById(int ticketId);
	public int insert(Ticket ticket);
	public int update(Ticket ticket);
	public int deleteById(int ticketId);
	
	public List<TicketType> getTicketTypeListByConcert(int concertId);
	public List<SeatStatic> listSeatStaticBySeatLevel(int seatLevel);
	
	public SeatStatic getRandomSeat(int ticketType);
	public SeatStatic getSeatStaticById(int id);
	
	public String createTicketQrString(Ticket t);
	
	 public List<Ticket> listByOrderId(int orderId);
	}
