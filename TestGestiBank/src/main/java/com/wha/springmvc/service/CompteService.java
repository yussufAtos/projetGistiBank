package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.Debit;

public interface CompteService {
	
	

	Compte findCompteById(int id);
	List<Compte> findComptesClient(int id);
    Compte saveCompte(Compte compte);
	void updatcompte(Compte compte) ;

	
}
