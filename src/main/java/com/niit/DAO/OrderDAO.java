package com.niit.DAO;

import java.util.List;

import com.niit.model.Order;

public interface OrderDAO {
	public void addOrder(Order order);
	public void cancelOrder(Order order);
	public void updateOrder(Order order);
	public List<Order> displayOrder(Order order);

}
