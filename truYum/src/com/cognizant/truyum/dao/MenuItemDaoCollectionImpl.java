package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
		
	
		private static List<MenuItem> menuItemList;
		public MenuItemDaoCollectionImpl() {
			super();
			if(menuItemList==null)
			{
				List<MenuItem> obj=new ArrayList<MenuItem>();
				
				obj.add(new MenuItem(0, "Sandwich", 0, null, null, false));
				obj.add("Burger");
				obj.add("Pizza");
				obj.add("French Fries");
				obj.add("Chocolate Brownie");
				
				
				
				
				
				
			}
			// TODO Auto-generated constructor stub
		}
			public List<MenuItem> getMenuItemListAdmin() {
				// TODO Auto-generated method stub
				return null;
			}
	}

		
		
		
			
		

		
		

