package org.alvas.one_to_one.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.alvas.one_to_one.dto.Aadhar;
import org.alvas.one_to_one.dto.Person;

public class PersonDAO {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("appu");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	public Person savePerson(Person p,Aadhar a) {
		entityTransaction.begin();
		entityManager.persist(a);
		entityManager.persist(p);
		entityTransaction.commit();
		return p;
	}
	public Person getPersonAadhar(int id) {
		Person person=entityManager.find(Person.class, id);
		return person;
	}
	public List<Person> getAllPersons(){
		Query query=entityManager.createQuery("select p from Person p");
		List<Person> p=query.getResultList();
		return p;
	}
	public Person deletePerson(int id) {
		Person person=entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		return person;
	}
	public Person updatePerson(Person p,Aadhar a,int id) {
		Person person=entityManager.find(Person.class, id);
		person.setName(p.getName());
		Aadhar aadhar=entityManager.find(Aadhar.class, id);
		aadhar.setAadharNumber(a.getAadharNumber());
		person.setAadhar(aadhar);
		entityTransaction.begin();
		entityManager.merge(person);
		entityManager.merge(aadhar);
		entityTransaction.commit();
		return person;
		
	}
}
