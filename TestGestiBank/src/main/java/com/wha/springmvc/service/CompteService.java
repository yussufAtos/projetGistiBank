package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;

public interface CompteService {
	
	

	Compte findCompteById(int id);
	List<Compte> findComptesClient(int id);

  

	CompteRemunerateur saveCompteRemunerateur(CompteRemunerateur cr);
	CompteCourant saveCompteCourant(CompteCourant cc1);	
	
	Compte saveCompte(Compte compte);
	
}
