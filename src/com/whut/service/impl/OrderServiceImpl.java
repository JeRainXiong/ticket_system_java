package com.whut.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.dao.OrderDao;
import com.whut.entity.Order;
import com.whut.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao dao;
	@Override
	public List<Order> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<Order> listPage(Map map) {
		// TODO Auto-generated method stub
		return dao.listPage(map);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public Order getById(int orderId) {
		// TODO Auto-generated method stub
		return dao.getById(orderId);
	}

	@Override
	public int insert(Order order) {
		// TODO Auto-generated method stub
		return dao.insert(order);
	}

	@Override
	public int update(Order order) {
		// TODO Auto-generated method stub
		return dao.update(order);
	}

	@Override
	public int deleteById(int orderId) {
		// TODO Auto-generated method stub
		return dao.deleteById(orderId);
	}

    @Override
    public List<Order> listByUserId(int userId, int beginPage, int pageRows) {
        // TODO 自动生成的方法存根
        int begin = (beginPage -1)*pageRows;
        Map map = new HashMap();
        map.put("begin", begin);
        map.put("rows", pageRows);
        map.put("userId", userId);
        // TODO Auto-generated method stub
        return dao.listByUserId(map);
    }

}
