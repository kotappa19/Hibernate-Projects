package com.training.hibernate_school;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("appu");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		while(true) {
			System.out.println("1-Add Student\n2-Update Student\n3-Delete Student\n4-Display Student\n5-Exit\nEnter Your Choice");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:{
			System.out.println("Enter the Student ID");
			int id=sc.nextInt();
			System.out.println("Enter the Student Name");
			String name=sc.next();
			System.out.println("Enter the E-mail");
			String email=sc.next();
			System.out.println("Enter the Student Phone Number");
			long phone=sc.nextLong();
			Student s=new Student();
			s.setId(id);
			s.setName(name);
			s.setEmail(email);
			s.setPhone(phone);
			entityTransaction.begin();
			entityManager.persist(s);
			entityTransaction.commit();
			break;
			}
			case 2:{
			System.out.println("Enter the Student ID");
			int id=sc.nextInt();
			System.out.println("Enter the Student Name");
			String name=sc.next();
			System.out.println("Enter the Student E-mail");
			String email=sc.next();
			System.out.println("Enter the Phone Number");
			long phone=sc.nextLong();
			Student s=entityManager.find(Student.class, id);
			s.setName(name);
			s.setEmail(email);
			s.setPhone(phone);
			entityTransaction.begin();
			entityManager.merge(s);
			entityTransaction.commit();
			break;
			}
			case 3:{
				System.out.println("Enter the Student ID");
				int id=sc.nextInt();
				Student s=entityManager.find(Student.class, id);
				entityTransaction.begin();
				entityManager.remove(s);
				entityTransaction.commit();
				break;
			}
			case 4:{
				Query query=entityManager.createQuery("select st from Student st");
				List<Student> list=query.getResultList();
				list.forEach(st->System.out.println(st));
				break;
			}
			case 5:{System.exit(0);}
			default:{System.out.println("Enter a Valid Choice");}
			}
		}
	}

}
