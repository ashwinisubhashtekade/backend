package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.OrderDAO;
import com.niit.dbconfig.DBConfig;
import com.niit.model.Order;
import com.niit.model.User;


@Transactional  
public class OrderDAOImpl implements OrderDAO {

	Transaction tx;
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
	
			
		try
		{
			tx=DBConfig.getSession().beginTransaction();
			DBConfig.getSession().save(order);
			tx.commit();
		
		}
		catch(Exception e)
		{

			tx.rollback();	
		}
		}
		
		
	

	public void cancelOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		try
		{
			tx=DBConfig.getSession().beginTransaction();
			DBConfig.getSession().update(order);
			tx.commit();
		
		}
		catch(Exception e)
		{

			tx.rollback();
			
		}
		
	}
		
	

	public List<Order> displayOrder(Order order) {
		// TODO Auto-generated method stub
		
		try {
			return DBConfig.getSession().createQuery("from com.niit.model.Order").list();
			
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return null;
	}

		
	}


