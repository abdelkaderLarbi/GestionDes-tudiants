package com.Etude.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Etude.dao.EtudiantRepo;
import com.Etude.dao.Etudiant;
@Service
public class Imple implements ImetierEtude{
	@Autowired
	
	private EtudiantRepo ETURepo;

	@Override
	public List<Etudiant> Recherch() {
		// TODO Auto-generated method stub
		return ETURepo.findAll();
	}

	@Override
	public Etudiant rechId(Long id) {
		// TODO Auto-generated method stub
		return ETURepo.findById(id).get();
	}

	@Override
	public Etudiant ajouter(Etudiant p) {
		// TODO Auto-generated method stub
		Etudiant Etu= ETURepo.save(p);
		return Etu;
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		ETURepo.deleteById(id);
		
	}

		
	
	

}
