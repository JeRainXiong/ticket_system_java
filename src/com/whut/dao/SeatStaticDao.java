package com.whut.dao;

import com.whut.entity.SeatStatic;

public interface SeatStaticDao {

	public SeatStatic getById(int id);
	public int insert(SeatStatic seatStatic);
	public int update(SeatStatic seatStatic);
	public int deleteById(int ticketTypeId);
}
