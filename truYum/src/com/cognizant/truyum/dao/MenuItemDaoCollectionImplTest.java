package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String args[]) throws ParseException, ClassNotFoundException, IOException, SQLException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testAddCartItem();

	}

	static void testGetMenuItemListAdmin() throws ParseException, ClassNotFoundException, IOException, SQLException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}

	static void testGetMenuItemListCustomer() throws ParseException, IOException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}

	static void testModifyMenuItem() throws ParseException, IOException {
		MenuItem obj = new MenuItem(5, "Chocolate Brownie", 32.0f, true, new DateUtil().convertToDate("02/11/2022"),
				"Dessert", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItemDao.modifyMenuItem(obj);

		menuItemDao.getMenuItem(5);

	}

	static void testMenuItem() {

	}
	static void testAddCartItem() throws ParseException, IOException {
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.addCartItem(1,5);
		
	}
}
