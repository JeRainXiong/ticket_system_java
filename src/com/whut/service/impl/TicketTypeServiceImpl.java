package com.whut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.TicketTypeDao;
import com.whut.entity.TicketType;
import com.whut.service.TicketTypeService;

@Service
public class TicketTypeServiceImpl implements TicketTypeService{

	@Autowired
	TicketTypeDao dao;
	
	@Override
	public TicketType getByTypeId(int ticketTypeId) {
		// TODO 自动生成的方法存根
		return dao.getByTypeId(ticketTypeId);
	}

	@Override
	public int insert(TicketType ticketType) {
		// TODO 自动生成的方法存根
		return dao.insert(ticketType);
	}

	@Override
	public int update(TicketType ticketType) {
		// TODO 自动生成的方法存根
		return dao.update(ticketType);
	}

	@Override
	public int deleteByTypeId(int ticketTypeId) {
		// TODO 自动生成的方法存根
		return dao.deleteByTypeId(ticketTypeId);
	}

}
