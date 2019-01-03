package com.whut.dao;

import java.util.List;

import com.whut.entity.SeatStatic;

public interface SeatStaticDao {

	public SeatStatic getById(int id);
	public int insert(SeatStatic seatStatic);
	public int update(SeatStatic seatStatic);
	public int deleteById(int ticketTypeId);
	
	public List<SeatStatic> listBySeatLevel(int seatLevel);
	
}
