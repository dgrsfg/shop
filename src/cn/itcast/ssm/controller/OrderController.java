package cn.itcast.ssm.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Cart;
import cn.itcast.ssm.po.CartItem;
import cn.itcast.ssm.po.Orders;
import cn.itcast.ssm.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/saveOrder",
			method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView addCart(HttpSession session){
		System.out.println("TTTTTTTTTTTTTTTTT");
		Cart cart=(Cart) session.getAttribute("cart");
		/*Collection<CartItem> cartItems=cart.getCartItems();
		HashSet<CartItem> orderCartItems = new HashSet<CartItem>();
		for(CartItem cartItem : cartItems){  
			orderCartItems.add(cartItem);
        }  */
		Orders order=new Orders();
		order.setOrdertime(new Date());
		//order.setCartItems(orderCartItems);
		order.setTotal(cart.getTotal());
		order.setState(0);
		order=orderService.insert(order);
		session.removeAttribute("cart");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("order",order);
		modelAndView.setViewName("/WEB-INF/jsp/order.jsp");
		return modelAndView;
	}
}
