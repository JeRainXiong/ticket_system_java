package com.whut.service;

import java.util.List;
import java.util.Map;

import com.whut.entity.Order;

public interface OrderService {
	public List<Order> listAll();
	public List<Order> listPage(Map map);
	public int count();//统计总条数
	public Order getById(int orderId);
	public int insert(Order order);
	public int update(Order order);
	public int deleteById(int orderId);
	
	
}
