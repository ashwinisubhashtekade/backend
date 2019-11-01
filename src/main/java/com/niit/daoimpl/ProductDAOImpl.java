package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.ProductDAO;
import com.niit.dbconfig.DBConfig;
import com.niit.model.Product;

@Transactional
public class ProductDAOImpl implements ProductDAO
{
	SessionFactory sessionFactory;

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().save(product);	
		
	}

	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(product);
		
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().update(product);
		
	}

	public List<Product> displayProducts() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product").list();
			
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return null;
	}
	

	public Product displayProductById(Product product) {
		// TODO Auto-generated method stub
		try {
			Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product where productid= :productid");
			query.setParameter("productid",product.getProductid());
			return (Product)query.getResultList().get(0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Product displayProductByName(Product product) {
		// TODO Auto-generated method stub
		try {
			Query query=DBConfig.getSession().createQuery("from com.niit.model.Product where productname= :productname");
			query.setParameter("productname",product.getProductname());
			return (Product)query.getResultList().get(0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return null;
	}

}
