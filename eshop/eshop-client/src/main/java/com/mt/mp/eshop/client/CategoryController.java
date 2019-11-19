package com.mt.mp.eshop.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mt.mp.eshop.model.Category;
import com.mt.mp.eshop.service.category.CategoryService;

@Path("category")
public class CategoryController {
	
	private CategoryService categoryService;

	public CategoryController() {
		categoryService = DependencyInjector.getInstance().getCategoryService();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewCategory(Category category) {
		categoryService.save(category);
		return "OK";
	}
	
	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories(){
		return new ArrayList<Category>(categoryService.findAll(Category.class));
	}
	
	@GET
	@Path("/{id}")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public Category getCategory(@PathParam("id") Long id){
		return categoryService.findById(Category.class, id);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCategory(@QueryParam("id") Long id) {
		System.out.println(id);
		Category category = categoryService.findById(Category.class, id);
		categoryService.delete(category);
		return "OK";
	}
	
	
	

}
