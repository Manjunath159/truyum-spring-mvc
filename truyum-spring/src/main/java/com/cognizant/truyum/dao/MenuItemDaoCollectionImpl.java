package com.cognizant.truyum.dao;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component
@ImportResource("classpath:spring-config.xml")

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	@Autowired

	private List<MenuItem> menuItemList;

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
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
		MenuItem a = null;
		for (MenuItem obj : menuItemList) {
			if (obj.getId() == menuItemId) {
				a = obj;
			}
		}
		return a;

	}
}
