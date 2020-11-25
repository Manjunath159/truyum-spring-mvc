package com.cognizant.truyum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller

public class MenuItemController {
	@Autowired
	private MenuItemService menuItem;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/show-menu-item-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws ClassNotFoundException, IOException, SQLException {
		LOGGER.info("Start");
		List<MenuItem> menuItemListAdmin = menuItem.getMenuItemListAdmin();
		model.addAttribute(menuItemListAdmin);
		LOGGER.info("End");
		return "menu-item-list-admin";

	}

	@GetMapping(value = "/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws IOException {
		LOGGER.info("Start");
		List<MenuItem> menuItemListCustomer = menuItem.getMenuItemListCustomer();
		model.addAttribute(menuItemListCustomer);
		LOGGER.info("end");

		return "menu-item-list-customer";
	}

	@GetMapping(value = "/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam long menuItemId, ModelMap model) throws IOException {
		LOGGER.info("Start");
		MenuItem item = menuItem.getMenuItem(menuItemId);

		List<String> list = Arrays.asList(new String[] { "Starters", "Main Course", "Desert", "Drinks" });

		model.addAttribute("menuItem", item);
		model.addAttribute("catogoryList", list);

		LOGGER.info("end");
		return "edit-menu-item";
	}

}
