package org.training.one_to_one_bi.controller;

import java.util.Scanner;

import org.training.one_to_one_bi.dao.PersonDAO;
import org.training.one_to_one_bi.dto.Pan;
import org.training.one_to_one_bi.dto.Person;

public class personUpdateController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PersonDAO dao=new PersonDAO();
		Person person=new Person();
		Pan pan=new Pan();
		System.out.println("Enter the Person ID to update");
		int id=sc.nextInt();
		System.out.println("Enter the Person Name");
		person.setPersonName(sc.next());
		System.out.println("Enter the Person E-mail");
		person.setPersonEmail(sc.next());
		System.out.println("Enter the PAN Number");
		pan.setPanNumber(sc.next());
		System.out.println("Enter the PAN Address");
		pan.setPanAddress(sc.next());
		pan.setPerson(person);
		dao.updatePerson(id, person, pan);
	}

}
