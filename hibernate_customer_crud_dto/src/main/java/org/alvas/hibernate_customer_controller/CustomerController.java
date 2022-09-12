package org.alvas.hibernate_customer_controller;

import java.util.List;
import java.util.Scanner;

import org.alvas.hibernate_customer_crud_dao.CustomerDAO;
import org.alvas.hibernate_customer_crud_dto.Customer;

public class CustomerController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CustomerDAO cd = new CustomerDAO();
		while (true) {
			System.out.println("1-Save Customer\n2-Update Customer\n3-Delete Customer\n4-Display Customer\n5-Get Customer By Name\n6-Exit\nEnter Your Choice");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:{
				Customer c = new Customer();
				System.out.println("Enter the Customer Name");
				c.setName(sc.next());
				System.out.println("Enter the Customer E-mail");
				c.setEmail(sc.next());
				System.out.println("Enter the Customer Phone Number");
				c.setPhone(sc.nextLong());
				cd.saveCustomer(c);
			}
				break;
			case 2:{
				Customer c = new Customer();
				System.out.println("Enter the Customer ID to update");
				int cid = sc.nextInt();
				System.out.println("Enter the Customer Name");
				c.setName(sc.next());
				System.out.println("Enter the Customer E-mail");
				c.setEmail(sc.next());
				System.out.println("Enter the Customer Phone Number");
				c.setPhone(sc.nextLong());
				cd.updateCustomer(c, cid);
			}
				break;
			case 3:
				System.out.println("Enter the Customer ID to delete");
				int id = sc.nextInt();
				cd.deleteCustomerByID(id);
				break;
			case 4: {
				List<Customer> ct = cd.getAllData();
				ct.forEach(customer -> System.out.println(customer));
			}
				break;
			case 5:
				System.out.println("Enter the Customer Name");
				String name = sc.next();
				List<Customer> ct = cd.getCustomerByName(name);
				ct.forEach(customer -> System.out.println(customer));
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Enter a Valid Choice");
			}

		}
	}

}
