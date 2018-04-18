package com.wha.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.User;

@Repository("compteDao")
public class CompteDaoImpl extends AbstractDao<Integer, Compte> implements CompteDao {

	@SuppressWarnings("unchecked")
	public List<Compte> findAllComptes() {
		List<Compte> Comptes = getEntityManager().createQuery("SELECT cp FROM Compte cp ").getResultList();

		return Comptes;
	}

	@Override
	public Compte findCompteById(int id) {
		Compte compte = getByKey(id);
		return compte;
	}

	@Override
	public void updateCompte(Compte compte) {

		update(compte);

	}

	@Override
	public Compte saveCompte(Compte compte) {
		persist(compte);
		return compte;
	}

	@SuppressWarnings("unchecked")

	public List<Compte> findComptesClient(int id) {
		// TODO Auto-generated method stub
		List<Compte> listComptes = getEntityManager()
				.createQuery("SELECT cp FROM Compte cp where cp.client.id = :idcli").setParameter("idcli", id)
				.getResultList();

		return listComptes;
	}

	@Override
	public void deleteCompte(int id) {
		// TODO Auto-generated method stub
		Compte  compte = getByKey(id);
		delete(compte);
	}


}
