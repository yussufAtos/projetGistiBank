package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Operation;
@Repository("operationDao")
public class OperationDaoImlp extends AbstractDao<Integer, Operation> implements OperationDao {

	@SuppressWarnings("unchecked")

    @Override
	public Operation saveOperation(Operation op) {
		persist(op);
		return op;
	}

	@Override
	public List<Operation> findOprationsCompte(int id) {
		// TODO Auto-generated method stub
		
	List<Operation> listOperations=  getEntityManager().createQuery("SELECT op FROM Operation op where op.compte.numeroCompte= :idcompte")
				.setParameter("idcompte", id).getResultList();		
		
		return listOperations;
	}

	@Override
	public void debiterCompte(Compte compte, Debit debit) {
		// TODO Auto-generated method stub

		double decouvert=0;
		if(compte instanceof CompteCourant )
			decouvert =((CompteCourant) compte).getDecouvert();
		
		
		if(compte.getSolde()-debit.getMontant()>decouvert) {
		compte.setSolde(compte.getSolde() - debit.getMontant());
		debit.setCompte(compte);
		}
		else {
			
			throw new RuntimeException("Solde insuffisant");
		}

	}

	@Override
	public void crediterCompte(Compte compte,Credit credit) {
		// TODO Auto-generated method stub
		compte.setSolde(compte.getSolde() + credit.getMontant());
		credit.setCompte(compte);

	}

	
	
	

}
