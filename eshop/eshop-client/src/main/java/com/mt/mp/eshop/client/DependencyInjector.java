package com.mt.mp.eshop.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.mt.mp.eshop.dao.category.CategoryDaoImpl;
import com.mt.mp.eshop.dao.product.ProductDaoImpl;
import com.mt.mp.eshop.dao.role.RoleDaoImpl;
import com.mt.mp.eshop.service.category.CategoryService;
import com.mt.mp.eshop.service.category.CategoryServiceImpl;
import com.mt.mp.eshop.service.product.ProductService;
import com.mt.mp.eshop.service.product.ProductServiceImpl;
import com.mt.mp.eshop.service.role.RoleService;
import com.mt.mp.eshop.service.role.RoleServiceImpl;

import lombok.Getter;

@Getter
public class DependencyInjector extends HttpServlet {

	private static final long serialVersionUID = 8879030820673911369L;

	private RoleService roleService;
	
	private ProductService productService;

	private CategoryService categoryService;
	
	private static DependencyInjector INSTANCE;
	
	public DependencyInjector() throws Exception {
		if(INSTANCE != null) {
			throw new Exception("This class can't have more than one instance.");
		}
		INSTANCE = this;
	}

	@Override
	public void init() throws ServletException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ESHOP_UNIT");
		EntityManager em = emf.createEntityManager();

		// Inject dependencies
		roleService = new RoleServiceImpl(new RoleDaoImpl(em));
		productService = new ProductServiceImpl(new ProductDaoImpl(em));
		categoryService = new CategoryServiceImpl(new CategoryDaoImpl(em));
	}

	public static DependencyInjector getInstance() {
		return INSTANCE;
	}

}
