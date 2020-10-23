package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	List<MenuItem> getMenuItemListAdmin();

	List<MenuItem> getMenuItemListCustomer();

	static void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub

	}

	MenuItem getMenuItem(long menuItemId);

}
