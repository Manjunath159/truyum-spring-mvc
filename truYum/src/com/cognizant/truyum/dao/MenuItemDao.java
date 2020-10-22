package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao  {
	   List<MenuItem> getMenuItemListAdmin();
	   List<MenuItem> getMenuItemListCustomer() throws ParseException;
	   void modifyMenuItem(MenuItem menuItem);
	   MenuItem getMenuItem(long menuItemId);
		 
	 

}
