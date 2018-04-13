package com.wha.springmvc.dao;

import java.util.Collection;



import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;




import com.wha.springmvc.model.User;
import com.wha.springmvc.model.Visitor;
@Repository("VisitorDao")

public class VisitorDaoImpl extends AbstractDao<Integer, Visitor> implements VisitorDao {

	// An alternative to Hibernate.initialize()
			protected void initializeCollection(Collection<?> collection) {
				if (collection == null) {
					return;
				}
				collection.iterator().hasNext();
			}

	@Override
	public void save(Visitor visitor) {
		persist(visitor);

	}

	//affiche toutes les demandes
	@SuppressWarnings("unchecked")
	public Collection<Visitor> findAllVisitors() {
		List<Visitor> visitors = getEntityManager().createQuery("SELECT v FROM Visitor v").getResultList();				
		
		if (visitors instanceof Visitor) {
			
			visitors.iterator();
			return visitors;
			
		}

		return visitors;
		
	}

	@SuppressWarnings("unchecked")
	public Collection<Visitor> findAllAffectedVisitor(int affectation) {
		List<Visitor> visitors = getEntityManager().createQuery("SELECT v FROM Visitor v WHERE v.affectation LIKE :int").setParameter("int", affectation).getResultList();				
		return visitors;
	}

	@Override
	public void deleteAllVisitors() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVisitorById(int id) {
		Visitor visitor = getByKey(id);
		delete(visitor);

	}

	@Override
	public Visitor findByIdVisitor(int id) {
		Visitor visitor = getByKey(id);
		return visitor;
	}

	@Override
	public Visitor findByName(String name) {
		System.out.println("name: "+ name);
		try {
			Visitor visitor = (Visitor) getEntityManager().createQuery("SELECT v FROM Visitor v WHERE v.username LIKE :name").setParameter("name", name).getSingleResult();
			return visitor;
			
		} catch (NoResultException ex) {
			return null;
		}
	}

}
