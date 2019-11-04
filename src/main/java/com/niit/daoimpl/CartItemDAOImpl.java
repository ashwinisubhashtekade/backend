package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.CartItemDAO;

import com.niit.model.CartItem;

@Transactional
public class CartItemDAOImpl implements CartItemDAO
{
 SessionFactory sessionFactory;
 


 public void addCart(CartItem cart) {

 sessionFactory.getCurrentSession().save(cart);
 }
 public void deleteCart(CartItem cart) {
 sessionFactory.getCurrentSession().delete(cart);

 }

 public void updateCart(CartItem cart) {
 sessionFactory.getCurrentSession().update(cart);


 }

 public List<CartItem> displayCart()
 {
 try {
 return sessionFactory.getCurrentSession().createQuery("from com.Shoes.Model.CartItem").list();

 } catch (Exception e) {
 return null;

 }


 }



}

