package cn.itcast.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.OrdersMapper;
import cn.itcast.ssm.po.Orders;

public class OrderService {
	@Autowired
	private OrdersMapper ordersMapper;
	
	public Orders insert(Orders order){
		return ordersMapper.selectByPrimaryKey(ordersMapper.insert(order));
	}
}