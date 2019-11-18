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

import com.mt.mp.eshop.model.Product;
import com.mt.mp.eshop.service.product.ProductService;

@Path("/product")
public class ProductController {

	private ProductService productService;

	public ProductController() {
		productService = DependencyInjector.getInstance().getProductService();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewProduct(Product product) {
		productService.save(product);
		return "OK";
	}
	
	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts(){
		return new ArrayList<Product>(productService.findAll(Product.class));
	}
	
	@GET
	@Path("/{id}")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public Product getProduct(@PathParam("id") Long id){
		return productService.findById(Product.class, id);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(@QueryParam("id") Long id) {
		System.out.println(id);
		Product product = productService.findById(Product.class, id);
		productService.delete(product);
		return "OK";
	}

}
