package com.cognizant.truyum.model;

import java.util.List;

public class Cart {

	/**
	 * 
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	private List<MenuItem> newUserMenuList;
	private double total;
	public List<MenuItem> getNewUserMenuList() {
		return newUserMenuList;
	}

	public void setNewUserMenuList(List<MenuItem> newUserMenuList) {
		this.newUserMenuList = newUserMenuList;
	}

	public double getTotal() {
		return total;
	}

	

	public Cart(List<MenuItem> newUserMenuList) {
		super();
		this.newUserMenuList=newUserMenuList;
		
		// TODO Auto-generated constructor stub
	}

	public Cart(List<MenuItem> newUserMenuList, double total) {
		// TODO Auto-generated constructor stub
		super();
		this.newUserMenuList=newUserMenuList;
		this.total=total;
	}

	public List<MenuItem> getMenuItemList() {
		// TODO Auto-generated method stub
		return  newUserMenuList;
	}

	public void setMenuItemList(List<MenuItem> newUserMenuList) {
		// TODO Auto-generated method stub
		this.newUserMenuList=newUserMenuList;
		
	}

	public void setTotal(double total) {
		// TODO Auto-generated method stub
		this.total=total;
		
	}

}
