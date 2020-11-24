package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException;

	List<MenuItem> getMenuItemListCustomer() throws IOException;

public void modifyMenuItem(MenuItem menuItem);
	

	MenuItem getMenuItem(long menuItemId) throws IOException;

}
