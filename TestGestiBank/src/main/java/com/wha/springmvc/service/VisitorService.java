package com.wha.springmvc.service;

import java.util.Collection;

import com.wha.springmvc.model.Visitor;

public interface VisitorService {

void save(Visitor visitor);
	
	//affiche toutes les demandes
	Collection<Visitor> findAllVisitors();
	
	//affiche toutes les affectations
	Collection<Visitor> findAllAffectedVisitor(int affectation);
	
	void deleteAllVisitors();
	
	void deleteVisitorById(int id);
	
	//affecte une demande d'inscription
	void updateVisitor(Visitor visitor);
	
	boolean isVisitorExist(Visitor visitor);
	
	Visitor findByIdVisitor(int id);
	
	Visitor findByName(String name);
	
}
