package fr.solutec;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Address;
import fr.solutec.entities.User;
import fr.solutec.repository.AddressRepository;
import fr.solutec.repository.UserRepository;

@SpringBootApplication
public class PrimoSpringApplication implements CommandLineRunner{
	
	@Autowired //permet de manipulé les méthodes qui CrudRepisotory(present dans le UserRepository)
	
	private UserRepository userRepo;
	
	@Autowired //permet de manipuler les méthodes de crudRepisotory(prensent dans le AdressRepository)
	private AddressRepository addressRepo;

	public static void main(String[] args) {
		SpringApplication.run(PrimoSpringApplication.class, args);
		System.out.println("lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Address a1=new Address(null,"120 rue d'Assas","Paris","75006");
		Address a2=new Address(null,"40 avenue d'Etienne","Biarritz","64200");
		Address a3=new Address(null,"87 rue de Tolbiac", "Paris","75013");
		Address a4=new Address(null,"22 rue Lahouze", "Anglet","64100");
		Stream.of(a1,a2,a3,a4).forEach(a -> {
			addressRepo.save(a);
		});
		
		User u1=new User(null,"Cornet","Athur",14,"azerty","rose",a4); //ici on met null pour l'id pcq c'est un Long alors que pour un int on aurait mis 0
		User u2=new User(null,"Eustache","Juliette",23,"juju","toto", a2);
		User u3=new User(null,"Msaidie","Zaher",25,"zaherM","espoir", a3);
		User u4=new User(null,"Tsouladze","Gaspard",19,"gaseus","limbo", a1);
		//userRepo.save(u1);//creer l'utilisateur dans la bbd
		
		Stream.of(u1,u2,u3,u4).forEach(u -> {
			userRepo.save(u);
		});
		
		/*userRepo.findAll().forEach(u ->{
			System.out.println(u.toString());
		});
		
		//System.out.println(userRepo.findByLoginAndMdp("azerty", "rose").get().toString());
		//ici notre methode retourne un Optional donc pour avoir un User on rajoute le .get()
		//on aurait aussi pu faire en sorte que le methode retourne directement un user mais Optional<User> plus professionnel
		Optional<User> uP= userRepo.findByLoginAndMdp("azerty", "ros");
		  if(uP.isPresent()){
		 System.out.println("connexion ok");
			System.out.println(uP.get().toString());
		  }
		  else{
		  System.out.println("user not found");
		  }
		 // Ici c'est la meme chose mais si y a une faute ou pas d'utilisateur permet de dire true ou false en fonction s'il trouve plutot que null
		 
		}*/

}
}
