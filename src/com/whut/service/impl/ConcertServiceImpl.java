package com.whut.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.ConcertDao;
import com.whut.entity.Concert;

@Service
public class ConcertServiceImpl implements com.whut.service.ConcertService {
	@Autowired
	ConcertDao dao;
	@Override
	public List<Concert> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<Concert> listPage(int beginPage,int pageRows) {
		
		int begin = (beginPage -1)*pageRows;
		Map map = new HashMap();
		map.put("begin", begin);
		map.put("rows", pageRows);
		// TODO Auto-generated method stub
		return dao.listPage(map);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public Concert getById(int concertId) {
		// TODO Auto-generated method stub
		return dao.getById(concertId);
	}

	@Override
	public int insert(Concert concert) {
		// TODO Auto-generated method stub
		return dao.insert(concert);
	}

	@Override
	public int update(Concert concert) {
		// TODO Auto-generated method stub
		return dao.update(concert);
	}

	@Override
	public int deleteById(int concertId) {
		// TODO Auto-generated method stub
		return dao.deleteById(concertId);
	}

	@Override
	public List<Concert> listByName(String name) {
		// TODO �Զ����ɵķ������
		return dao.listByName(name);
	}

}
