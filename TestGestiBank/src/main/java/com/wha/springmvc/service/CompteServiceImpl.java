package com.wha.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteDao;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.Debit;


@Service("compteService")
@Transactional

public class CompteServiceImpl implements CompteService {
	
	
    @Autowired
	private CompteDao compteDao ;
 
	public Compte saveCompte(Compte compte) {
		return compteDao.saveCompte(compte);
	}

	@Override
	public List<Compte> findComptesClient(int id) {
		// TODO Auto-generated method stub
		return compteDao.findComptesClient(id);
	}

	@Override
	public Compte findCompteById(int id) {
		// TODO Auto-generated method stub
		return compteDao.findCompteById(id);
	}

	@Override
	public void updatcompte(Compte compte) {
		compteDao.updateCompte(compte);
		
	}

	@Override
	public void deleteCompte(int id) {
		// TODO Auto-generated method stub
		compteDao.deleteCompte(id);
	}

	


	
	

}
