package com.subhadeep.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.subhadeep.DAO.CategoryDAO;
import com.subhadeep.Mainproject.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping("/category")
	public String showCategory(Model m)
	{
		List<Category>listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories );
		return "Category";
	}
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("catname")String catname,@RequestParam("catdesc")String catDesc,Model m)
	{
		Category category=new Category();
		category.setCategoryName(catname);
		category.setCategoryDesc(catDesc);
		categoryDAO.addCategory(category);
		
		List<Category>listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories );
		return "Category";
	}
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=(Category)categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		List<Category>listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories );
		return "Category";
	}
	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=(Category)categoryDAO.getCategory(categoryId);
		
		List<Category>listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories );
		m.addAttribute("categoryInfo",category);
		return "UpdateCategory";
}
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catid")int categoryId,@RequestParam("catname")String catname,@RequestParam("catdesc")String catDesc,Model m)
	{
		Category category=(Category)categoryDAO.getCategory(categoryId);
		category.setCategoryName(catname);
	    category.setCategoryDesc(catDesc);
	    categoryDAO.updateCategory(category);
	    
	    List<Category>listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories );
		return "Category";
	}
}