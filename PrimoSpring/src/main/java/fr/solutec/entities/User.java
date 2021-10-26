package fr.solutec.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

@NoArgsConstructor @AllArgsConstructor @Data
public class User {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private int age;
	//rendre unique la colonne login
	private String login;
	private String mdp;
	@ManyToOne // permet de faire la relation entre user et adress (un user peut avoir 1 ou plusieurs adresses) puis le lien est fait directement dans la bbd
	//Attention, le sens compte, (manytoone ou onetomany)
	private Address address;

}
