package com.subhadeep.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.subhadeep.DAO.CategoryDAO;
import com.subhadeep.DAO.ProductDAO;
import com.subhadeep.Mainproject.Category;
import com.subhadeep.Mainproject.Product;
@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute(product);
		
		List<Product>listProducts=productDAO.getProducts();
		m.addAttribute("listProducts",listProducts);
		m.addAttribute("categoryList",this.getCategories());
	     
		return "Product";
	}
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile filedet,Model m)
	{
		productDAO.addProduct(product);
		Product product1=new Product();
		m.addAttribute(product1);
		
		List<Product> listProducts=productDAO.getProducts();
		m.addAttribute("listProducts", listProducts);
		m.addAttribute("categoryList",this.getCategories());
		
		String path="C:\\Users\\SUBHADEEP\\eclipse-workspace\\ProjectFrontend\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getProductId())+".jpg";
		File file=new File(path);
		if(!filedet.isEmpty())
		{
			try{
				
				byte [] buffer= filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(file);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
				
			}catch(Exception e)
			{
				m.addAttribute("errorInfo","Exception Arised:"+e.getMessage());
			}
		}
		else
		{
			m.addAttribute("errorInfo","There is System Problem No Image Insertion");
		}
		
		return "Product";
}

	@RequestMapping(value="/deleteProduct/{productId}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute(product1);
		
		List<Product>listProducts=productDAO.getProducts();
		m.addAttribute("listProducts",listProducts );
		m.addAttribute("categoryList",this.getCategories());
		
		return "Product";
	
}

	@RequestMapping(value="/editProduct/{productId}",method=RequestMethod.GET)
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=(Product)productDAO.getProduct(productId);
		m.addAttribute(product);
		
		List<Product>listProducts=productDAO.getProducts();
		m.addAttribute("listproducts", listProducts);
		m.addAttribute("productInfo",product);

		{
			return "UpdateProduct";
		}
	}
	
	
	@RequestMapping(value="/UpdateProduct", method=RequestMethod.POST)
	public String UpdateProduct(@RequestParam("productId")int productId,@RequestParam("productName")String 

productName,@RequestParam("price")int price,@RequestParam("stock")int stock,@RequestParam("categoryId")int 

categoryId,@RequestParam("supplierId")int supplierId,@RequestParam("productDesc")String productDesc,Model m)
	{
	     
	    Product product=(Product) productDAO.getProduct(productId);
	    product.setProductName(productName);
		product.setPrice(price);
		product.setCategoryId(categoryId);
		product.setSupplierId(supplierId);
		product.setProductDesc(productDesc);
		productDAO.updateProduct(product);
	    m.addAttribute(product);
		List<Product> listproducts=productDAO.getProducts();
		m.addAttribute("listProducts",listproducts);
		
		return "Product";
		
	}

	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category>listCategories = categoryDAO.listCategories();
		LinkedHashMap<Integer,String> categoryList= new LinkedHashMap<Integer,String>();
		for(Category category:listCategories)
		{
			categoryList.put(category.getCategoryId(),category.getCategoryName());
		}
		return categoryList;
		
	}
	@RequestMapping(value="/productDesc/{productId}")
	public String showProductDesc(@PathVariable("productId")int productId, Model m)
	{
		Product product= productDAO.getProduct(productId);
		m.addAttribute("product",product);
		return "ProductDesc";
}
}


