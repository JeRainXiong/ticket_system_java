package com.whut.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.UserDao;
import com.whut.entity.User;
import com.whut.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;
	@Override
	public List<User> listAll() {
	
		
		return dao.listAll();
	}

	@Override
	public List<User> listPage(Map map) {
		// TODO Auto-generated method stub
		return dao.listPage(map);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public User getById(int userId) {
		// TODO Auto-generated method stub
		return dao.getById(userId);
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.getByUsername(username);
	}

	@Override
	public User getByRealname(String userRealname) {
		// TODO Auto-generated method stub
		return dao.getByRealname(userRealname);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return dao.insert(user);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return dao.update(user);
	}

	@Override
	public int deleteById(int userId) {
		// TODO Auto-generated method stub
		return dao.deleteById(userId);
	}

}
