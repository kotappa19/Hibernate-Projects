package org.training.one_to_many.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.training.one_to_many.dto.Mobile;
import org.training.one_to_many.dto.Sim;

public class MobileDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("appu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Mobile saveMobile(Mobile m, List<Sim> list) {
		entityTransaction.begin();
		entityManager.persist(m);
		for (Sim sim : list) {
			entityManager.persist(sim);
		}
		entityTransaction.commit();
		return m;
	}

	public Mobile updateMobile(int id, String name, String serviceprovider,String simname) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		mobile.setName(name);
		entityTransaction.begin();
		for (Sim s : mobile.getSim()) {
			if(s.getName().equals(simname)) {
			s.setProvider(serviceprovider);
			entityManager.merge(s);
			}
		}
		entityManager.merge(mobile);
		entityTransaction.commit();
		return mobile;
	}

	public Mobile getById(int id) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		return mobile;
	}

	public Mobile deleteById(int id) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		entityTransaction.begin();
		for (Sim s : mobile.getSim()) {
			entityManager.remove(s);
		}
		entityManager.remove(mobile);
		entityTransaction.commit();
		return mobile;
	}

}
