package com.cognizant.truyum.service;

import java.io.IOException;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

//@Service("cartService")
//@ImportResource("classpath:spring-config.xml")

public class CartService {
	@Autowired
	private CartDao cartDao;

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException, IOException {
		return cartDao.getAllCartItems(userId);

	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void addCartItem(long userId, long menuItemId) throws ParseException, IOException {
		cartDao.addCartItem(userId, menuItemId);

	}

	public void removeCartItem(long userId, long menuItemId) {

	}

}
