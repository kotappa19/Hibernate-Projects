package org.training.one_to_one_bi.controller;

import java.util.Scanner;

import org.training.one_to_one_bi.dao.PersonDAO;
import org.training.one_to_one_bi.dto.Pan;
import org.training.one_to_one_bi.dto.Person;

public class PersonSaveController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonDAO dao=new PersonDAO();
		Person person=new Person();
		Pan pan=new Pan();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Person Name");
		person.setPersonName(sc.next());
		System.out.println("Enter the Person E-mail ID");
		person.setPersonEmail(sc.next());
		System.out.println("Enter the Pan Number");
		pan.setPanNumber(sc.next());
		System.out.println("Enter the Pan Address");
		pan.setPanAddress(sc.next());
		pan.setPerson(person);
		dao.savePerson(person, pan);
	}	

}
