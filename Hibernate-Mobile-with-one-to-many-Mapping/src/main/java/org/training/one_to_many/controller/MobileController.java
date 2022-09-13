package org.training.one_to_many.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.training.one_to_many.dao.MobileDAO;
import org.training.one_to_many.dto.Mobile;
import org.training.one_to_many.dto.Sim;

public class MobileController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MobileDAO dao = new MobileDAO();
		boolean accept = true;
		do {
			System.out.println(
					"1-Save Mobile\n2-Update Mobile\n3-Delete Mobile\n4-Display Mobile By ID\n5-Exit\nEnter Your Choice");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				Mobile mobile = new Mobile();
				System.out.println("Enter the Mobile name");
				mobile.setName(sc.next());
				System.out.println("Enter the Mobile Model");
				mobile.setModel(sc.next());
				System.out.println("Enter the Number of Sims");
				int n = sc.nextInt();
				List<Sim> list = new ArrayList<Sim>();
				for (int i = 0; i < n; i++) {
					Sim sim = new Sim();
					System.out.println("Enter the Sim Name");
					sim.setName(sc.next());
					System.out.println("Enter the Sim Provider");
					sim.setProvider(sc.next());
					list.add(sim);
				}
				mobile.setSim(list);
				dao.saveMobile(mobile, list);

			}
				break;
			case 2: {
				System.out.println("Enter the Mobile ID to update");
				int id = sc.nextInt();
				System.out.println("Enter the Mobile Name to update");
				String name = sc.next();
				System.out.println("Enter the Sim Name");
				String simname=sc.next();
				System.out.println("Enter the Service Provider to update");
				String serviceprovider = sc.next();
				dao.updateMobile(id, name, serviceprovider,simname);
			}
				break;
			case 3: {
				System.out.println("Enter the Mobile ID to delete");
				dao.deleteById(sc.nextInt());
			}
				break;
			case 4: {
				System.out.println("Enter the Mobile ID to display");
				Mobile mobile = dao.getById(sc.nextInt());
				System.out.println(mobile);
			}
				break;
			case 5:
				accept = false;
			default:
				System.out.println("Enter a Valid Choice");
			}
		} while (accept);
	}

}
