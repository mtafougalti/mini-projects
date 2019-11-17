package com.mt.mp.eshop.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mt.mp.eshop.model.Role;
import com.mt.mp.eshop.service.generic.GenericService;

@Path("/")
public class RoleController {
	
	private GenericService<Role> roleService;
	
	public RoleController() {
		roleService = DependencyInjector.getInstance().getRoleService();
	}
	
	@GET
	@Path("/hello")
	public String hello(){
		return "Hello World !";
	}
	
	@GET
	@Path("/roles")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public List<Role> getAllRoles(){
		return new ArrayList<Role>(roleService.findAll(Role.class));
	}
}
