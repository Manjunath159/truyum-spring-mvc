package com.cognizant.truyum.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;


@Controller
public class CartController {

	@Autowired
	private CartService service;
	
	List<MenuItem> list;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/add-to-cart")
	public String addToCart(@RequestParam int id, ModelMap model) throws ParseException, IOException {
		LOGGER.info("start");
		service.addCartItem(1, id);
		model.put("addCartStatus",true);
		LOGGER.info("end");
		return "forward:/show-menu-list-customer";
	}
}