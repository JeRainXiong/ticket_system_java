package com.whut.dao;

import com.whut.entity.TicketType;

public interface TicketTypeDao {

	public TicketType getByTypeId(int ticketTypeId);
	public int insert(TicketType ticketType);
	public int update(TicketType ticketType);
	public int deleteByTypeId(int ticketTypeId);
}
