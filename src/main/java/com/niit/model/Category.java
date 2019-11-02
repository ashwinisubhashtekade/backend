package com.niit.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int categoryid;
	@Column
	private String categoryname;
 
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "category")
	private Set<SubCategory> subcategories;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "category")
	private Set<Product> products;
	
	
 public Set<SubCategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(Set<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
public int getCategoryid() {
	return categoryid;
}
public void setCategoryid(int categoryid) {
	this.categoryid = categoryid;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
 
}
