package com.whut.service;

import java.util.List;
import java.util.Map;

import com.whut.entity.User;

public interface UserService {
	public List<User> listAll();
	public List<User> listPage(Map map);//分页
	public int count();//统计总条数
	public User getById(int userId);
	public User getByUsername(String username);
	public User getByRealname(String userRealname);
	public int insert(User user);
	public int update(User user);
	public int deleteById(int userId);
}
