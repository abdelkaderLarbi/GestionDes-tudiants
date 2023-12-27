package com.Etude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.Etude.dao.EtudiantRepo;
import com.Etude.dao.Etudiant;

@SpringBootApplication
public class GestionDesEtudiantssApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GestionDesEtudiantssApplication.class, args);
	}
    
	@Autowired
	EtudiantRepo p;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
        p.save(new Etudiant(null, "abdelkader", "gafsa", null));
        
		
	}
	

}
