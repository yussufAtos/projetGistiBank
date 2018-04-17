package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.Debit;

public interface CompteDao {
	
	
void updateCompte(Compte compte) ;
List<Compte> findComptesClient(int id);
Compte findCompteById(int id);
Compte saveCompte(Compte compte);
	


}
