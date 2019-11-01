package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@Transactional
public class UserDAOImpl implements UserDAO {
	
	SessionFactory sessionFactory;
	@Autowired

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		
	sessionFactory.getCurrentSession().save(user);
	return true;
 
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(user);	
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().update(user);
		
	}

	public List<User> displayUsers() {
		// TODO Auto-generated method stub
		
		try {
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.User").list();
			
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return null;
	}

	public User displayUserById(User user) {
		// TODO Auto-generated method stub
		
		try {
			Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.User where userid= :userid");
			query.setParameter("userid",user.getUserid());
			return (User)query.getResultList().get(0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public User displayUserByName(User user) {
		// TODO Auto-generated method stub
		
		try {
			Criteria ctx=sessionFactory.getCurrentSession().createCriteria(User.class);
			return (User)ctx.add(Restrictions.eq("username",user.getUsername())).list().get(0);
			
		}
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

}
