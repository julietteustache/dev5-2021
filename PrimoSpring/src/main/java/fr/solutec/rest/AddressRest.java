package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Address;
import fr.solutec.repository.AddressRepository;

@RestController @CrossOrigin("*")

public class AddressRest {
	
	@Autowired
	private AddressRepository addressRepo;
	@PostMapping("address")
	public Address saveAddress(@RequestBody Address a) { //requestBody c'est la valeur que l'on peut mettre en body de la request
		return addressRepo.save(a);                      //obligatoire pour que ça marche (valable pour un post et pour un put)
	}

}
