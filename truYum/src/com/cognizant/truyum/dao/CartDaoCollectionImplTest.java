package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	void main(String[] args) throws ParseException, CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();

	}

	void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 5);
		cartDao.getAllCartItems(1);

	}

	void testAddCartItem() throws ParseException, CartEmptyException {
		// TODO Auto-generated method stub
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 5);
		List<MenuItem> lst = cartDao.getAllCartitems(1);
		lst.forEach(System.out::println);

	}

	void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> lst = cartDao.getAllCartItems(1);
		lst.forEach(System.out::println);

	}

}
