package com.esprit.msGestionClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/clients")
public class ClientRestAPI {

	@Autowired
	private ClientService clientService;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	

	@GetMapping
	public List<Client> getAllClient(){
		return clientService.getAllClient();
	}
	
	@GetMapping(value="/{name}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Client getClientByName(@Param(value="name") String name) {
		return clientService.getClientByName(name);
	}
	
	
	@PostMapping
	public Client addClient (@RequestBody Client client){
		return clientService.addClient(client);
	}
	
	@PutMapping(value= "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Client updateClient (
			@PathVariable(value = "id")int id,
			@RequestBody Client client){
		return clientService.updateClient(id, client);
	}
	
	@DeleteMapping(value= "/{id}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteClient (@PathVariable(value = "id")int id){
		return clientService.deleteClient(id);
	}
	
	
	@GetMapping(value="nbrContact" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public int getNbrContact(@Param(value="id") int id) {
		return clientService.getNbrContact(id);
	}
	

}

