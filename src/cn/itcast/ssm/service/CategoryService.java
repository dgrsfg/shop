package cn.itcast.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.CategoryMapper;
import cn.itcast.ssm.po.Category;
import cn.itcast.ssm.po.Categorysecond;

public class CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> findAll(){
		return categoryMapper.selectAll();
	}
}