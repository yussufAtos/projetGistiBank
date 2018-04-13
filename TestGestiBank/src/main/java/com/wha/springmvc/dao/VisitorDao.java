package com.wha.springmvc.dao;

import java.util.Collection;

import com.wha.springmvc.model.Visitor;

public interface VisitorDao {
	
	void save(Visitor visitor);
	
	//affiche toutes les demandes
	Collection<Visitor> findAllVisitors();
	
	//affiche toutes les affectations
	Collection<Visitor> findAllAffectedVisitor(int affectation);
	
	Visitor findByIdVisitor(int id);
	
	void deleteAllVisitors();
	
	void deleteVisitorById(int id);
	
	Visitor findByName(String name);
	
	

}
