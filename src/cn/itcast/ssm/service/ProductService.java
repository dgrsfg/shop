package cn.itcast.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ProductMapper;
import cn.itcast.ssm.po.Product;

public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> findHot(int hotNumber){
		return productMapper.selectHot(hotNumber);
	}
	
	public List<Product> findNew(int newNumber){
		return productMapper.selectNew(newNumber);
	}
	
	public Product findByPid(Integer pid){
		return productMapper.selectByPrimaryKey(pid);
	}
	
	public List<Product> findByCid(Integer cid){
		return productMapper.selectByCid(cid);
	}
	
	public List<Product> findByCsid(Integer csid){
		return productMapper.selectByCsid(csid);
	}
}