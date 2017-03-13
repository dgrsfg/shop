package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Category;
import cn.itcast.ssm.po.Product;
import cn.itcast.ssm.service.CategoryService;
import cn.itcast.ssm.service.ProductService;

@Controller
public class IndexController {

	private  static final int HOT_NUM=10;
	private  static final int NEW_NUM=10;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/index",
			method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView index(HttpSession session){
		System.out.println("TTTTTTTTTTTTTTTTT");
		List<Category> cList = categoryService.findAll();
		List<Product> hList = productService.findHot(HOT_NUM);
		List<Product> nList = productService.findNew(NEW_NUM);
		ModelAndView modelAndView=new ModelAndView();
		session.setAttribute("cList", cList);
		modelAndView.addObject("hList",hList);
		modelAndView.addObject("nList",nList);
		modelAndView.setViewName("/WEB-INF/jsp/index.jsp");
		return modelAndView;
	}
}
