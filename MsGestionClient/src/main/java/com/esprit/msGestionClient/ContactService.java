package com.esprit.msGestionClient;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	@Autowired
	public ContactRepository contactRepository;
	
	@Autowired
	public ClientRepository clientRepository;
	
	public Contact addContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public List<Contact> getAllContact(){
		return contactRepository.findAll();
	}
	
	public Contact getContactById(int id) {
		return contactRepository.findById(id).get();
	}
	
	public Contact getContactByType(String type) {
		return contactRepository.getContactByType(type);
	}
	
	public  Client addContactToClient(int idContact,int idClient) {
		Contact contact = contactRepository.findById(idContact).get();
		Client client = clientRepository.findById(idClient).get();
		client.getContacts().add(contact);
		return clientRepository.save(client);
		
	}
	
	public Contact updateContact(int id,Contact newContact) {
		if(contactRepository.findById(id).isPresent()) {
			Contact existingProduit = contactRepository.findById(id).get();
			if(newContact.getType() != null) {
				existingProduit.setType(newContact.getType());
			}
			if(newContact.getValue() != null) {
				existingProduit.setValue(newContact.getValue());
			}
			
			
			return contactRepository.save(existingProduit);
		}else {
			return null;
		}
	}
	
	
	
	
	
}