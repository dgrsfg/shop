package cn.itcast.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Categorysecond;
import cn.itcast.ssm.po.Product;
import cn.itcast.ssm.service.ProductService;

@Controller
public class ProductController {
	
	private Product product;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product_findByPid",
			method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView product_findByPid(@RequestParam(value = "pid") Integer pid){
		product = productService.findByPid(pid);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("product",product);
		modelAndView.setViewName("/WEB-INF/jsp/product.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/product_findByCid",
			method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView product_findByCid(@RequestParam(value = "cid") Integer cid){
		List<Product> products= productService.findByCid(cid);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("products",products);
		modelAndView.setViewName("/WEB-INF/jsp/productList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/product_findByCsid",
			method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView product_findByCsid(@RequestParam(value = "csid") Integer csid){
		List<Product> products= productService.findByCsid(csid);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("products",products);
		modelAndView.setViewName("/WEB-INF/jsp/productList.jsp");
		return modelAndView;
	}
}
