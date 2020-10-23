package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	void addCartItem(long userId, long menuItemId) throws ParseException, IOException;

	List<MenuItem> getAllCartitems(long userId) throws CartEmptyException;

	void removeCartItem(long userId, long menuItemId);

	List<MenuItem> getAllCartItems(int i);
}
