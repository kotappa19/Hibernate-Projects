package org.alvas.hibernate_customer_crud_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.alvas.hibernate_customer_crud_dto.Customer;

public class CustomerDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("appu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Customer saveCustomer(Customer c) {
		entityTransaction.begin();
		entityManager.persist(c);
		entityTransaction.commit();
		return c;
	}

	public void updateCustomer(Customer c, int cid) {
		Customer c1=entityManager.find(Customer.class, cid);
		c1.setName(c.getName());
		c1.setEmail(c.getEmail());
		c1.setPhone(c.getPhone());
		entityTransaction.begin();
		entityManager.merge(c1);
		entityTransaction.commit();
	}

	public void deleteCustomerByID(int cid) {
		Customer c = entityManager.find(Customer.class, cid);
		entityTransaction.begin();
		entityManager.remove(c);
		entityTransaction.commit();
	}

	public List<Customer> getAllData() {
		Query query = entityManager.createQuery("select c from Customer c");
		List<Customer> ct = query.getResultList();
		return ct;
	}

	public List<Customer> getCustomerByName(String name) {
		Query query = entityManager.createQuery("select c from Customer c where c.name=?1");
		query.setParameter(1, name);
		List<Customer> ct = query.getResultList();
		return ct;
	}
}
