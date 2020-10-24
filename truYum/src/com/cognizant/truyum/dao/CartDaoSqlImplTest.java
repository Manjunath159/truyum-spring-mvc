package com.cognizant.truyum.dao;

import java.io.IOException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		testAddCartItem();
		testGetAllCartItem();
		testRemoveCartItem();
		testGetAllCartItem();
		
		
	}
	
	public static void testAddCartItem() throws IOException {
		CartDaoSqlImpl obj = new CartDaoSqlImpl();
		obj.addCartItem(2, 3);
		obj.addCartItem(1, 2);
		obj.addCartItem(2, 1);
		obj.addCartItem(1, 3);
		obj.addCartItem(2, 4);
	}
	
	public static void testGetAllCartItem() throws IOException {
		int user_id = 2;
		CartDaoSqlImpl obj = new CartDaoSqlImpl();
		try {
			List<MenuItem> menuItemList = obj.getAllCartItems(user_id);
			for(MenuItem item : menuItemList) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void testRemoveCartItem() throws IOException {
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
		long userId = 1;
	
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long menuItemId = 1;
		cartDaoImpl.removeCartItem(userId, menuItemId);
		
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}