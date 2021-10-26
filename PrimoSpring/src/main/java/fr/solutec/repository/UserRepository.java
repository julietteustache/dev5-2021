package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public Optional<User>findByLoginAndMdp(String login, String mdp); // ici il faut absolument mettre les meme nom que les attribut de la classe (dans notre classe User, on a mis login et mdp) si on avait email et password, il aurait fallu mettre email et password dans le nom de la methode
	// meme si la methode n'exsite pas encore, il y a le mot cle find au debut de la mthode donc cela va generer directement select, findby donc select...where
	
	public List<User> findByAddressVille(String ville);//obligé de faire AdressVille et pas Ville direct pcq dans la calsse User, c'est une adresse et pas le detail de l'adresse

	
}
