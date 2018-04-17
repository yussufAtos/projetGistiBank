package com.wha.springmvc.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wha.springmvc.dao.OperationDao;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Operation;

@Service("operationService")
@Transactional

public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationDao operationDao;

	@Override
	public Operation saveOperation(Operation op) {
		return operationDao.saveOperation(op);

	}

	@Override
	public List<Operation> findOprationsCompte(int id) {
		// TODO Auto-generated method stub
		return operationDao.findOprationsCompte(id);
	}

	@Override
	public void debiterCompte(Compte compte, Debit debit) {
		// TODO Auto-generated method stub
		operationDao.debiterCompte(compte, debit);
	}

	@Override
	public void crediterCompte(Compte compte, Credit credit) {
		// TODO Auto-generated method stub
		operationDao.crediterCompte(compte, credit);
	}

}
