package com.Etude.Metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Etude.dao.Etudiant;

public interface ImetierEtude {
    public List<Etudiant>Recherch();
    public Etudiant rechId(Long id);
    public Etudiant ajouter (Etudiant p);
    public void supprimer (Long id);
   // public Page<Personne> findp(int p, int s);
    	
    	
    	
    }
