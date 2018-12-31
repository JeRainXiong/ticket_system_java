package com.whut.dao;
import java.util.List;
import java.util.Map;

import com.whut.entity.Concert;

public interface ConcertDao {
	public List<Concert> listAll();
	public List<Concert> listPage(Map map);
	public List<Concert> listByName(String name);
	public int count();//缁熻鎬绘潯鏁�
	public Concert getById(int concertId);
	public int insert(Concert concert);
	public int update(Concert concert);
	public int deleteById(int concertId);
}
