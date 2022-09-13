package org.training.one_to_one_bi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.training.one_to_one_bi.dto.Pan;
import org.training.one_to_one_bi.dto.Person;

public class PersonDAO {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("appu");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	 
	public Person savePerson(Person person,Pan pan) {
		entityTransaction.begin();
		entityManager.persist(pan);
		entityManager.persist(person);
		entityTransaction.commit();
		return person;
	}
	public Pan getById(int id) {
		Pan pan=entityManager.find(Pan.class, id);
		return pan;
	}
	public Pan removePerson(int id) {
		Pan pan=entityManager.find(Pan.class, id);
		Person person=entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(pan);
		entityManager.remove(person);
		entityTransaction.commit();
		return pan;
	}
	public Pan updatePerson(int id,Person p,Pan pn) {
		Pan pan=entityManager.find(Pan.class, id);
		Person person=entityManager.find(Person.class, id);
		pan.setPanNumber(pn.getPanNumber());
		pan.setPanAddress(pn.getPanAddress());
		person.setPersonName(p.getPersonName());
		person.setPersonEmail(p.getPersonEmail());
		pan.setPerson(person);
		entityTransaction.begin();
		entityManager.merge(pan);
		entityManager.merge(person);
		entityTransaction.commit();
		return pan;
	}
	
}
