package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	// get all clients
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	// add Client
	@PostMapping("/clients")
	public Client createClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}

	// get by ID a Client
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Client not exist with ID: " + id));
		return ResponseEntity.ok(client);
	}

	// update a Client
	@PutMapping("clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client newClient) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Client not exist with ID: " + id));
		client.setFirstNameClient(newClient.getFirstNameClient());
		client.setLastNameClient(newClient.getLastNameClient());
		client.setEmailClient(newClient.getEmailClient());
		Client updateClient = clientRepository.save(client);
		return ResponseEntity.ok(updateClient);
	}

	// delete a Client
	@DeleteMapping("clients/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Client not exist with ID: " + id));
		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
