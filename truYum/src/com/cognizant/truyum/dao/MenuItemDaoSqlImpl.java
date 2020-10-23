package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	private static PreparedStatement ps = null;

	@Override
	public List<MenuItem> getMenuItemListAdmin() throws IOException {

		try {
			// TODO Auto-generated method stub
			Connection connection = ConnectionHandler.getConnection();
			List<MenuItem> lst = new ArrayList<>();

			String query = "SELECT * FROM MENU_ITEMS";
			ps = connection.prepareStatement(query);

			ResultSet r = ps.executeQuery();
			while (r.next()) {
				MenuItem item = new MenuItem(r.getLong(1), r.getString(2), r.getFloat(3), r.getInt(4) == 1,
						r.getDate(5), r.getString(6), r.getInt(7) == 1);
				lst.add(item);

			}
			return lst;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() throws IOException {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionHandler.getConnection();
			List<MenuItem> lst = new ArrayList<>();
			String query = "SELECT * FROM MENU_ITEMS WHERE ACTIVE = TRUE AND dateOfLaunch < now()";
			ps = connection.prepareStatement(query);

			ResultSet r = ps.executeQuery();

			while (r.next()) {
				MenuItem item = new MenuItem(r.getLong(1), r.getString(2), r.getFloat(3), r.getInt(4) == 1,
						r.getDate(5), r.getString(6), r.getInt(7) == 1);
				lst.add(item);
			}
			return lst;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) throws IOException {
		// TODO Auto-generated method stub
		MenuItem obj = null;
		;
		try {
			Connection connection = ConnectionHandler.getConnection();
			String query = "SELECT * FROM MENU_ITEMS WHERE ID =?";
			ps = connection.prepareStatement(query);

			ps.setLong(1, menuItemId);

			ResultSet r = ps.executeQuery();

			if (r.next()) {
				MenuItem item = new MenuItem(r.getLong(1), r.getString(2), r.getFloat(3), r.getInt(4) == 1,
						r.getDate(5), r.getString(6), r.getInt(7) == 1);

			}
			return obj;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	void editMenuItem(MenuItem menuItem) throws IOException {
		try {
			Connection connection = ConnectionHandler.getConnection();
			String query = "UPDATE MENU_ITEMS SET item_name = ?, PRICE = ?, ACTIVE = ?, DATE_OF_LAUNCH = ?, CATEGORY = ?, FREE_DELIVERY = ? WHERE ID = ?";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			ps = connection.prepareStatement(query);
			ps.clearParameters();
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.isActive());
			ps.setString(4, format.format(menuItem.getDateOfLaunch()));
			ps.setString(5, menuItem.getCategory());
			ps.setBoolean(6, menuItem.isFreeDelivery());
			ps.setLong(7, menuItem.getId());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
