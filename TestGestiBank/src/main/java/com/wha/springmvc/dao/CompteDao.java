package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;

public interface CompteDao {
	
	
	



	List<Compte> findComptesClient(int id);
	
	Compte findCompteById(int id);
	
  

	CompteRemunerateur saveCompteRemunerateur(CompteRemunerateur cr);
	CompteCourant saveCompteCourant(CompteCourant cpc);
	Compte saveCompte(Compte compte);
	


}
