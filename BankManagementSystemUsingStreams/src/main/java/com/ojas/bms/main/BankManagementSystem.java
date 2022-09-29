package com.ojas.bms.main;

import java.util.Scanner;

import com.ojas.bms.menu.BankDetails;
import com.ojas.bms.model.Bank;

public class BankManagementSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("-------------------------------");
			System.out.println("|  BANK MANAGEMENT SYSTEM     |");
			System.out.println("-------------------------------");
			System.out.println("|     1. ADMIN                |");
			System.out.println("|     2. CUSTOMER             |");
			System.out.println("|     3. EXIT                 |");
			System.out.println("--------------------------------");
			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				BankDetails.adminMainMenu();
				break;
			case 2:
				BankDetails.customerMainMenu();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Please select your choice range between 1-3 only");

			}

	}

	}

}
