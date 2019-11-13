package com.esprit.msGestionClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository  clientRepository;
	
	public Client addClient( Client client) {
		return clientRepository.save(client);
	}
	
	public List<Client> getAllClient(){
		return clientRepository.findAll();
	}
	
	public Client getProduitById(int id) {
		return clientRepository.findById(id).get();
	}
	
	public Client getClientByName(String name) {
		return clientRepository.getClientByName(name);
	}
	
	public Client updateClient(int id,Client newClient) {
		if(clientRepository.findById(id).isPresent()) {
			Client existingClient = clientRepository.findById(id).get();
			if(newClient.getName() != null) {
				existingClient.setName(newClient.getName());
			}
			if(newClient.getEmail() != null) {
				existingClient.setEmail(newClient.getEmail());
			}
			return clientRepository.save(existingClient);
		}
		else {
			return null;
		}
	}
	
	public String deleteClient(int id) {
		if(clientRepository.findById(id).isPresent()) {
			clientRepository.deleteById(id);
			return "Client supprimé";
		}else {
			return "Client non supprimé";

		}
	}
	
	public int getNbrContact(int  idClient) {
		Client client = clientRepository.findById(idClient).get();
		return client.getContacts().size();
	}
	
}