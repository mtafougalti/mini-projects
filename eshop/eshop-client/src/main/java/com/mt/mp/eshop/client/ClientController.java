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

import com.mt.mp.eshop.model.Client;
import com.mt.mp.eshop.service.client.ClientService;

@Path("/client")
public class ClientController {

	private ClientService clientService;

	public ClientController() {
		clientService = DependencyInjector.getInstance().getClientService();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewClient(Client client) {
		clientService.save(client);
		return "OK";
	}
	
	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getAllClients(){
		return new ArrayList<Client>(clientService.findAll(Client.class));
	}
	
	@GET
	@Path("/{id}")
	@Produces(value= {MediaType.APPLICATION_JSON})
	public Client getClient(@PathParam("id") Long id){
		return clientService.findById(Client.class, id);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteClient(@QueryParam("id") Long id) {
		System.out.println(id);
		Client client = clientService.findById(Client.class, id);
		clientService.delete(client);
		return "OK";
	}

}
