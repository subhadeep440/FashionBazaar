package com.subhadeep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.subhadeep.DAO.CartDAO;
import com.subhadeep.DAO.ProductDAO;
import com.subhadeep.Mainproject.Cart;
@Controller
public class CartController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	@RequestMapping(value="/Cart")
	public String showCart(HttpSession session,Model m)
	{   
		String username=(String)session.getAttribute("username");
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("totalAmount", this.calcTotalAmount(listCartItems));
		m.addAttribute("cartsize",listCartItems.size());
		return "Cart";
		
	}
	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session,Model m)
	{
	 Cart cart=new Cart();
	 String username=(String)session.getAttribute("username");
	 cart.setProductId(productId);
	 cart.setProductName(productDAO.getProduct(productId).getProductName());
	 cart.setPrice(productDAO.getProduct(productId).getPrice());
	 cart.setQuantity(quantity);
	 cart.setStatus("NP");
	cart.setUsername(username);
	
	cartDAO.addToCart(cart);
	List<Cart> listCartItems=cartDAO.listCartItems(username);
	m.addAttribute("cartItems", listCartItems);
	m.addAttribute("totalAmount", this.calcTotalAmount(listCartItems));
	m.addAttribute("cartsize",listCartItems.size());
	return "Cart";
}
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,HttpSession session,Model m)
	{
		 String username=(String)session.getAttribute("username");
		Cart cart=cartDAO.getCartItem(cartItemId);
		cart.setQuantity(quantity);
		cartDAO.updateItemFromCart(cart);
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("totalAmount", this.calcTotalAmount(listCartItems));
		m.addAttribute("cartsize",listCartItems.size());
		return "Cart";
	}

	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,HttpSession session,Model m)
	{
		 String username=(String)session.getAttribute("username");
		Cart cart=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteItemFromCart(cart);
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("totalAmount", this.calcTotalAmount(listCartItems));
		m.addAttribute("cartsize",listCartItems.size());
		return "Cart";
	}
	public int calcTotalAmount(List<Cart> cartItems)
	{
	
	int var=0,totalAmount=0;
	while(var<cartItems.size())
	{
		Cart cart=cartItems.get(var);
		totalAmount=totalAmount+(cart.getPrice()*cart.getQuantity());
		var++;
	}
	return totalAmount;
}
}
