package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.CartItemDAO;
import com.niit.dbconfig.DBConfig;
import com.niit.model.CartItem;

@Transactional
public class CartItemDAOImpl implements CartItemDAO {
	Transaction tx;

	public void addCart(CartItem cart) {
		// TODO Auto-generated method stub
		try
		{
			tx=DBConfig.getSession().beginTransaction();
			DBConfig.getSession().save(cart);
			tx.commit();
		
		}
		catch(Exception e)
		{

			tx.rollback();	
		}
		}
		
	

	public void deleteCart(CartItem cart) {
		// TODO Auto-generated method stub
		
		try
		{
			tx=DBConfig.getSession().beginTransaction();
			DBConfig.getSession().delete(cart);
			tx.commit();
		
		}
		catch(Exception e)
		{

			tx.rollback();	
		}
		}
		
	

	public void updateCart(CartItem cart) {
		// TODO Auto-generated method stub
		try
		{
			tx=DBConfig.getSession().beginTransaction();
			DBConfig.getSession().update(cart);
			tx.commit();
		
		}
		catch(Exception e)
		{

			tx.rollback();	
		}
		}
		
	

	public List<CartItem> displayCart(CartItem cart) {
		// TODO Auto-generated method stub

		try {
			return DBConfig.getSession().createQuery("from com.niit.model.CartItem").list();
			
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return null;
	
		
	}

}
