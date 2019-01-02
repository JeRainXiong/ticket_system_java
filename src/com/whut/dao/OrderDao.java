package com.whut.dao;

import java.util.List;
import java.util.Map;

import com.whut.entity.Order;

public interface OrderDao {

	public List<Order> listAll();
	public List<Order> listPage(Map map);
	public int count();//统计总条数
	public Order getById(int orderId);
	public int insert(Order order);
	public int update(Order order);
	public int deleteById(int orderId);
	
	/**
	 * 根据Userid查对应的orders，参数有userId和分页参数
	 * @param map
	 * @return
	 */
    public List<Order> listByUserId(Map map);
}
