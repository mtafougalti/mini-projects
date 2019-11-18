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

import com.mt.mp.eshop.model.Role;
import com.mt.mp.eshop.service.role.RoleService;

@Path("/role")
public class RoleController {
	
	private RoleService roleService;
	
	public RoleController() {
		roleService = DependencyInjector.getInstance().getRoleService();
	}
	
	@GET
	@Path("/hello")
	public String hello(){
		return "Hello World !";
	}
	
	@GET
	@Path("/listAll")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public List<Role> getAllRoles(){
		return new ArrayList<Role>(roleService.findAll(Role.class));
	}
	
	@GET
	@Path("/{id}")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public Role getRole(@PathParam("id") Long id){
		return roleService.findById(Role.class, id);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewRol(Role role) {
		System.out.println(role.getName());
		roleService.save(role);
		return "OK";
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteRole(@QueryParam("id") Long id) {
		System.out.println(id);
		Role role = roleService.findById(Role.class, id);
		roleService.delete(role);
		return "OK";
	}
}
