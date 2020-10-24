package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	private static MenuItemDaoSqlImpl obj = new MenuItemDaoSqlImpl();
	
	public static void main(String[] args) throws IOException, ParseException {
		
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItemListAdmin();
		testGetMenuItem();
	}
	
	public static void testGetMenuItemListAdmin() throws IOException {
		List<MenuItem> itemAdminList = obj.getMenuItemListAdmin();
		itemAdminList.forEach(System.out::println);
	}
	
	public static void testGetMenuItemListCustomer() throws IOException {
		List<MenuItem> itemCustomerList = obj.getMenuItemListCustomer();
		itemCustomerList.forEach(System.out::println);
	}

	public static void testModifyMenuItem() throws ParseException, IOException {
		MenuItem menuItem = new MenuItem(5, "Chocolate", 30.0f, true, new DateUtil().convertToDate("15/03/2017"), "Desert", true);
		obj.editMenuItem(menuItem);
	}
	
	public static void testGetMenuItem() throws IOException {
		MenuItem menuItem = obj.getMenuItem(2);
		if(menuItem == null) {
			System.out.println("The Item does not exist in our database");
			return;
		}
		System.out.println(menuItem);
	}
}
