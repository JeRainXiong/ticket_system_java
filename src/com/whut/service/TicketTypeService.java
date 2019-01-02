package com.whut.service;

import com.whut.entity.TicketType;

public interface TicketTypeService {

	public TicketType getByTypeId(int ticketTypeId);
	public int insert(TicketType ticketType);
	public int update(TicketType ticketType);
	public int deleteByTypeId(int ticketTypeId);
}
