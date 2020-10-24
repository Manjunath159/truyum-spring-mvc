package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;


public class CartDaoSqlImpl implements CartDao {
	private static PreparedStatement ps = null;
	
	@Override
	public void addCartItem(long userId, long menuItemId) throws IOException {

		try {
			
			Connection connection = ConnectionHandler.getConnection();
			
			String query = "INSERT INTO CART(CT_USER_ID, CT_MENU_ID) VALUES (?, ?)";
			ps = connection.prepareStatement(query);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			ps.executeUpdate();
			ps.clearParameters();
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException, IOException {
		List<MenuItem> lst = new ArrayList<>();
		Cart cart = new Cart(lst, 0);
		double total = 0;
		try {
			Connection connection = ConnectionHandler.getConnection();
			
			String query = "SELECT * FROM MENU_ITEMS WHERE ID IN (SELECT CT_MENU_ID FROM CART WHERE CT_USER_ID = ?)";
			ps = connection.prepareStatement(query);
			
			ps.setLong(1, userId);
			
			ResultSet r = ps.executeQuery();
			
			while(r.next()) {
				
				total += r.getFloat(3);
				
				MenuItem item = new MenuItem(r.getLong(1), r.getString(2), r.getFloat(3), r.getInt(4) == 1,
						r.getDate(5), r.getString(6), r.getInt(7) == 1);
				lst.add(item);
			}
			ps.clearParameters();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.setMenuItemList(lst);
		cart.setTotal(total);
		return lst;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws IOException {
		
		try {
			Connection connection = ConnectionHandler.getConnection();
			String query = "DELETE FROM CART WHERE CT_MENU_ID = ? AND CT_USER_ID = ?";
			
			ps = connection.prepareStatement(query);
			ps.setLong(1, menuItemId);
			ps.setLong(2, userId);
			
			ps.executeUpdate();
				
			ps.clearParameters();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}