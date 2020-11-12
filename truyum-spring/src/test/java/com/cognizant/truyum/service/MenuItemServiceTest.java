package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemServiceTest {

	private MenuItemService menuItemService;

	@Before
	public void initializeService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService = context.getBean(MenuItemService.class);

		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext("spring-config.xml");
		// context.scan("com.cognizant.truyum");
		// context.refresh();
		// menuItemService = (MenuItemService) context.getBean("menuItemService");

	}

	@Test
	public void testGetMenuItemListAdminSize() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> list = menuItemService.getMenuItemListAdmin();
		int a = list.size();
		assertSame(5, a);
	}

	@Test
	public void testGetMenuItemCustomerSize() throws IOException {
		List<MenuItem> list = menuItemService.getMenuItemListCustomer();
		int a = list.size();
		assertSame(3, a);

	}

	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() throws IOException {
		List<MenuItem> list = menuItemService.getMenuItemListCustomer();

		boolean answer = false;
		for (MenuItem obj : list) {
			if (obj.contains("French Fries"))
				answer = true;
			break;
		}
		assertFalse(answer);

		// assertThat(list,hasItems("Sandwich","Burger","Pizza","Chocolate Brownie"));

	}

	@Test
	public void testGetMenuItemListAdminContainsSandwich() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> list = menuItemService.getMenuItemListAdmin();
		boolean answer = false;
		for (MenuItem obj : list) {
			if (obj.getName().contentEquals("Sandwich"))
				answer = true;
		}
		assertTrue(answer);

	}

	@Test
	public void testGetMenuItem() throws IOException {
		long ans = menuItemService.getMenuItem(1).getId();
		assertEquals(1, ans);

	}

	@Test
	public void testModifyMenuItem() throws IOException {

		MenuItem newItem = new MenuItem(2, "Burger", 129, true, new Date(), "Main Course", true);
		menuItemService.editMenuItem(newItem);
		assertEquals(true, menuItemService.getMenuItem(2).isFreeDelivery());

	}
}
