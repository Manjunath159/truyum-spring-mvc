package com.cognizant.truyum.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;


@Service("menuItemService")
public class MenuItemService {
	
	private MenuItemDao menuItemDao;
	
	@Autowired
	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
		 return menuItemDao.getMenuItemListAdmin();
	}

	public List<MenuItem> getMenuItemListCustomer() throws IOException {
		return menuItemDao.getMenuItemListCustomer();
	}

	public MenuItem getMenuItem(long menuItemId) throws IOException {
		return menuItemDao.getMenuItem(menuItemId);
	}

	public void editMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);

	}
}
