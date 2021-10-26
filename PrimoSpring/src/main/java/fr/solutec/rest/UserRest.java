package fr.solutec.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*") // * permet que tout le monde puisse consommer les API

public class UserRest {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("user") // pour que les utilisteurs aient acces aux données (pour le front) 
	public Iterable<User> getAllUser(){ // iterable un peu comme une liste avc fonctionnalité en +
		return userRepo.findAll(); //dans tout les cas findAll retourne un Iterable
	}
	
	
	@GetMapping("user/{ville}") //avoir des données
	public List<User> getUserByVille(@PathVariable String ville){
		return userRepo.findByAddressVille(ville);
	}
	
	@PostMapping("user") //inserer des données 
	public User saveUser(@RequestBody User u) {
		return userRepo.save(u);
	}
	
	@PutMapping("user/{id}") //modifier un objet  --> considere qu'on a le user complet a modifer 
	public User modifUser(@PathVariable Long id, @RequestBody User u) {
		u.setId(id); //permet de fixer l'id du user pour ne pas avoir à le réecrire
		return userRepo.save(u);
	}
	
	@DeleteMapping("user/{id}")  
	public boolean suppUser(@PathVariable Long id ) {
		if(userRepo.findById(id).isPresent())
		{
			userRepo.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

}
