package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Operation;

public interface OperationService {
	
List<Operation> findOprationsCompte(int id );
Operation saveOperation(Operation op);
void debiterCompte(Compte compte, Debit debit);
void crediterCompte(Compte compte, Credit credit);
}
