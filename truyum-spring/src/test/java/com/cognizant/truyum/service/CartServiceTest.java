package com.cognizant.truyum.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {

	private CartService cartService;

	@Before
	public void initializeService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		cartService = context.getBean(CartService.class);

		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext("spring-config.xml");
		// context.scan("com.cognizant.truyum");
		// context.refresh();
		// cartService = (CartService) context.getBean("cartService");

	}

	@Test(expected = CartEmptyException.class)
	public void testGetAllCartItem() throws CartEmptyException, IOException {
		cartService.getAllCartItems(1);
	}

	@Test(expected = NullPointerException.class)

	public void testAddCartItem() throws ParseException, IOException, CartEmptyException {
		cartService.addCartItem(2, 2);
		boolean answer = false;

		for (MenuItem obj : cartService.getAllCartItems(2)) {
			if (obj.contains("burger")) {
				answer = true;
			}
		}
		assertTrue(answer);
	}

	@Test
	public void testRemoveCartitem() throws CartEmptyException, IOException {

		cartService.removeCartItem(2, 2);
		boolean answer = false;
		for (MenuItem obj : cartService.getAllCartItems(2)) {
			if (obj.contains("burger")) {
				answer = true;
			}
		}
		assertFalse(answer);
	}

}
