package com.wha.springmvc.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.VisitorDao;
import com.wha.springmvc.model.Visitor;

@Service("visitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private VisitorDao dao;

	@Override
	public void save(Visitor visitor) {
		dao.save(visitor);

	}

	@Override
	public Collection<Visitor> findAllVisitors() {
	
		return dao.findAllVisitors();
	}

	@Override
	public Collection<Visitor> findAllAffectedVisitor(int affectation) {
		
		return dao.findAllAffectedVisitor(affectation);
	}

	@Override
	public void deleteAllVisitors() {
		dao.deleteAllVisitors();

	}

	@Override
	public void deleteVisitorById(int id) {
		dao.deleteVisitorById((int)id);

	}

	//affecte  une demande d'inscription à un conseiller
	@Override
	public void updateVisitor(Visitor visitor) {
		Visitor entity = dao.findByIdVisitor((int) visitor.getId());
	if(entity!=null){
		entity.setUsername(visitor.getUsername());
		entity.setAddress(visitor.getAddress());
		entity.setEmail(visitor.getEmail());
		entity.setAffectation(visitor.getAffectation());
	}
	dao.save(entity);
	}

	@Override
	public boolean isVisitorExist(Visitor visitor) {
		
		return dao.findByName((String) visitor.getUsername())!=null;
	}

	@Override
	public Visitor findByIdVisitor(int id) {
		
		return dao.findByIdVisitor((int)id);
	}

	@Override
	public Visitor findByName(String name) {
		
		return dao.findByName((String) name);
	}

}
