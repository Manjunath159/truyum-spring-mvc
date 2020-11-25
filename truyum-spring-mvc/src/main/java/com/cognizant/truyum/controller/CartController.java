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

import com.cognizant.truyum.dao.CartEmptyException;
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
		return "show-menu-list-customer";
	}
	
	@GetMapping(value = "/show-cart")
    public String showCart(@RequestParam long userId, ModelMap model) throws IOException {
        
        LOGGER.info("Start");
        System.out.println("user id is " + userId);
        if(userId != 0) {
            try {
                List<MenuItem> cartItems = service.getAllCartItems(userId);
                System.out.println(cartItems);
                model.addAttribute("cartItems", cartItems);
                model.addAttribute("userId", userId);
                float total = 0f;
                for(MenuItem item : cartItems) {
                    total += item.getPrice();
                }
                model.addAttribute("total", total);
                LOGGER.info("End");
                return "cart";
            } catch (CartEmptyException e) {
                
                LOGGER.info("End");
                return "cart-empty";
                
            }
        }else {
            return "cart";
        }
    }
	  @GetMapping(value = "/remove-cart")
	    public String removeCart(@RequestParam long userId, @RequestParam long menuItemId, ModelMap model) throws IOException {
	        
	        service.removeCartItem(userId, menuItemId);

	        List<MenuItem> cartItems;
	        try {
	            cartItems = service.getAllCartItems(userId);
	            model.addAttribute("cartItems", cartItems);
	            model.addAttribute("userId", userId);
	            float total = 0f;
	            for(MenuItem item : cartItems) {
	                total += item.getPrice();
	            }
	            System.out.println(total);
	            model.addAttribute("total", total);
	        } catch (CartEmptyException e) {
	            
	        }
	        LOGGER.info("End");
	        return "cart";
	    }
	    
	    
}