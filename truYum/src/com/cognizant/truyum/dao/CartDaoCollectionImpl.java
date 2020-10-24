package com.cognizant.truyum.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	public void addCartItem(long userId, long menuItemId) throws ParseException, IOException {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem item = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(item);
			userCarts.get(userId).setMenuItemList(menuItemList);
		} else {
			List<MenuItem> newObj = new ArrayList<>();
			newObj.add(item);
			Cart obj1 = new Cart(newObj);
			userCarts.put(userId, obj1);
		}

	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		Cart obj = userCarts.get(userId);
		List<MenuItem> lst = obj.getMenuItemList();
		if (lst.isEmpty()) {
			throw new CartEmptyException();
		} else {
			double total = 0;
			for (MenuItem item : lst) {
				total += item.getPrice();
			}
			obj.setTotal(total);
		}
		return lst;
	}

	


	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Cart cart = userCarts.get(userId);
		List<MenuItem> lst = cart.getMenuItemList();
		for (MenuItem obj : lst) {
			if (obj.getId() == menuItemId) {
				lst.remove(obj);
			}

		}
	}}
		
	



	
	
