package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Cart;
import cn.itcast.ssm.po.CartItem;
import cn.itcast.ssm.po.Product;
import cn.itcast.ssm.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/addCart",
			method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView addCart(HttpSession session,
			@RequestParam(value = "pid") Integer pid,
			@RequestParam(value = "count") Integer count){
		Product product=productService.findByPid(pid);
		CartItem cartItem = new CartItem();
		cartItem.setPid(pid);
		cartItem.setProduct(product);
		cartItem.setCount(count);
		
		Cart cart= getCart(session);
		cart.addCart(cartItem);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/cart.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/clearCart",
			method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView clearCart(HttpSession session){
		Cart cart = getCart(session);
		cart.clearCart();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/cart.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/removeCart",
			method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView removeCart(HttpSession session,
			@RequestParam(value = "pid") Integer pid){
		Cart cart = getCart(session);
		cart.removeCart(pid);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/cart.jsp");
		return modelAndView;
	}
	
	public String myCart(){
		return "myCart";
	}
	private Cart getCart(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}
}
