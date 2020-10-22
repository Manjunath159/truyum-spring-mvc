package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {
	
	  void main (String args[]) throws ParseException {
		 testGetMenuItemListAdmin();
		 
		 
		
	}
	 void testGetMenuItemListAdmin() throws ParseException {
		  
		  MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		  List<MenuItem> menuItemList =menuItemDao.getMenuItemListAdmin();
		  for (MenuItem item : menuItemList) {
				System.out.println(item);
			}
	 }

}
