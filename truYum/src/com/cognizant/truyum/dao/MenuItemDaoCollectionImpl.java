package com.cognizant.truyum.dao;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws ParseException {
		super();
		List<MenuItem> obj = new ArrayList<>();
		if (menuItemList == null) {

			obj.add(new MenuItem(1, "Sandwich", 99.0f, true, new DateUtil().convertToDate("15/03/2017"), "Main Course",
					true));
			obj.add(new MenuItem(2, "Burger", 129.0f, true, new DateUtil().convertToDate("23/12/2017"), "Main Course",
					false));
			obj.add(new MenuItem(3, "Pizza", 149.0f, true, new DateUtil().convertToDate("21/08/2018"), "Main Course",
					false));
			obj.add(new MenuItem(4, "French Fries", 57.0f, false, new DateUtil().convertToDate("02/07/2017"),
					"Starters", true));
			obj.add(new MenuItem(5, "Chocolate Brownie", 32.0f, true, new DateUtil().convertToDate("02/11/2022"),
					"Dessert", true));

		}

		// TODO Auto-generated constructor stub
	}

	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		try {
			// TODO Auto-generated method stub
			List<MenuItem> arr = new ArrayList<>();

			Date currDate = new DateUtil().convertToDate("20/10/2020");
			for (MenuItem obj : menuItemList) {
				if (obj.isActive() && currDate.after(obj.getDateOfLaunch())) {
					arr.add(obj);
				}

			}
			return arr;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for (MenuItem obj : menuItemList) {
			if (menuItem.equals(obj)) {
				obj.setId(menuItem.getId());
				obj.setName(menuItem.getName());
				obj.setPrice(menuItem.getPrice());
				obj.setActive(menuItem.isActive());
				obj.setDateOfLaunch(menuItem.getDateOfLaunch());
				obj.setCategory(menuItem.getCategory());
				obj.setFreeDelivery(menuItem.isFreeDelivery());
//				

			}
		}
		menuItemList.add(menuItem);

	}

	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for (MenuItem obj : menuItemList) {
			if (obj.getId() == menuItemId) {
				return obj;
			}
		}
		return null;

	}
}
