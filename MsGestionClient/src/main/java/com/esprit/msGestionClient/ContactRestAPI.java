package com.esprit.msGestionClient;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/contacts")
public class ContactRestAPI {

	@Autowired
	private ContactService contactService;
	
	
	
	

	@GetMapping
	public List<Contact> getAllContact(){
		return contactService.getAllContact();
	}
	
	@GetMapping(value="type/{type}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Contact getContactByType(@Param(value="type") String type) {
		return contactService.getContactByType(type);
	}
	
	
	@PostMapping
	public Contact addContact (@RequestBody Contact contact){
		return contactService.addContact(contact);
	}
	
	@PutMapping(value= "/{id]",produces = MediaType.APPLICATION_JSON_VALUE)
	public Contact updateContact (
			@PathVariable(value = "id")int id,
			@RequestBody Contact contact){
		return contactService.updateContact(id, contact);
	}
	
	
	

}

