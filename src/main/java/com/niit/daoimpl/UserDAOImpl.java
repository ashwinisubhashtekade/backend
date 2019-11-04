package com.niit.daoimpl;

import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		
		user.setEnabled(true);
		user.setAuthority("user");
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
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
			System.out.println("Inside Method.......");
			Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.User where username= :username");
			query.setParameter("username",user.getUsername());
			User u=(User)query.getResultList().get(0);
			System.out.println(u.getUsername());
			System.out.println(u.getPassword());
			System.out.println("Inside Method.......");
			return u;
			
		}
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

}
