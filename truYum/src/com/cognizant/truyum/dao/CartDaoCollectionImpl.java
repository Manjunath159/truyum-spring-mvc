package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long,Cart> userCarts;

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MenuItem> getAllCartitems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		
	}
	

}
