package org.training.one_to_one_bi.controller;

import java.util.Scanner;

import org.training.one_to_one_bi.dao.PersonDAO;

public class personRemoveController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PersonDAO dao=new PersonDAO();
		System.out.println("Enter the Person ID to remove");
		dao.removePerson(sc.nextInt());
	}

}
