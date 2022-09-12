package org.alvas.one_to_one.controller;

import java.util.Scanner;

import org.alvas.one_to_one.dao.PersonDAO;
import org.alvas.one_to_one.dto.Aadhar;
import org.alvas.one_to_one.dto.Person;

import antlr.collections.List;

public class PersonController {
	
	static PersonDAO dao=new PersonDAO();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1-Save Person\n2-Display Person By ID\n3-Display All Persons\n4-Delete Person\n5-Update Person\n6-Exit\nEnter Your Choice");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:{
					Person person=new Person();
					Aadhar aadhar=new Aadhar();
					System.out.println("Enter the Person Name");
					person.setName(sc.next());
					System.out.println("Enter the Person E-mail");
					person.setEmail(sc.next());
					System.out.println("Enter the Aadhar Number");
					aadhar.setAadharNumber(sc.nextLong());
					System.out.println("Enter the Address");
					aadhar.setAddress(sc.next());
					person.setAadhar(aadhar);
					dao.savePerson(person, aadhar);
			}
			break;
			case 2:{
				System.out.println("Enter the Person ID");
				Person person=dao.getPersonAadhar(sc.nextInt());
				System.out.println(person);
			}
			break;
			case 3:{
				java.util.List<Person> p=dao.getAllPersons();
				p.forEach(person->System.out.println(person));
			}
			break;
			case 4:{
				System.out.println("Enter the Person ID to Delete");
				int id=sc.nextInt();
				dao.deletePerson(id);
			}
			break;
			case 5:{
				Person person=new Person();
				Aadhar aadhar=new Aadhar();
				System.out.println("Enter the Person ID");
				int id=sc.nextInt();
				System.out.println("Enter the Person Name");
				person.setName(sc.next());
				System.out.println("Enter the Aadhar Number");
				aadhar.setAadharNumber(sc.nextLong());
				person.setAadhar(aadhar);
				dao.updatePerson(person, aadhar, id);
			}
			break;
			case 6:System.exit(0);
			default:System.out.println("Enter a Valid Choice");
			}
			
		}
	}

}
