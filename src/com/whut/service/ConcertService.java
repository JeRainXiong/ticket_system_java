package com.whut.service;

import java.util.List;
import java.util.Map;

import com.whut.entity.Concert;

public interface ConcertService {
	public List<Concert> listAll();
	public List<Concert> listPage(int beginPage,int pageRows);
	public List<Concert> listByName(String name);
	public int count();//
	public Concert getById(int concertId);
	public int insert(Concert concert);
	public int update(Concert concert);
	public int deleteById(int concertId);
}
