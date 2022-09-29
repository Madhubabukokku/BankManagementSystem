package com.ojas.bms.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ojas.bms.dao.BankDaoImpl;
import com.ojas.bms.main.BankManagementSystem;
import com.ojas.bms.model.Bank;

public class BankDetails {
	static BankDaoImpl dao=new BankDaoImpl();
	public static List<Bank> originaList = new ArrayList<Bank>();
	public static List<Bank> tempList = new ArrayList<Bank>();
public static void adminMainMenu(){
	
	System.out.println("-----------------------");
	System.out.println("1.ADD ACCOUNT          ");
	System.out.println("2.SEARCH ACCOUNT       ");
	System.out.println("3.VIEW ALL ACCOUNTS    ");
	System.out.println("4.DELETE ACCOUNT       ");
	System.out.println("5.BACK                 ");
	System.out.println("-----------------------");
	System.out.println("enter your choice");
	Scanner s=new Scanner(System.in);
	int choice=s.nextInt();
	switch(choice){
	case 1:
	       System.out.println("enter your choice");
	       System.out.println("-----------------");
	       System.out.println("1.CURRENT ACCOUNT");
	       System.out.println("2.SAVINGS ACCOUNT");
	       System.out.println("3.BACK           ");
	       System.out.println("-----------------");
	       int choice1=s.nextInt();
	       switch(choice1){
	       case 1:dao.currentAccount();
	              adminMainMenu();
	              break;
	       case 2:dao.savingsAccount();
	              adminMainMenu();
	              break;
	       case 3:BankManagementSystem.main(null);
	              break;
	       default:System.out.println("enter valid number");       
	       }
	       break;
	case 2:System.out.println("Enter Account number");
	       List<Bank> searchAccount = dao.searchAccount(s.nextInt());
	       System.out.println("ACCNAME" + "\t" + "ACCNUM" + "\t" + "MOBNUM" + "\t" + "BALANCE");
	       System.out.println("------------------------------");
	       System.out.println(searchAccount);
	       adminMainMenu();
	       break;
	case 3:List<Bank> accounts = dao.viewAllAccounts();
	       System.out.println("ACCNAME" + "\t" + "ACCNUM" + "\t" + "MOBNUM" + "\t" + "BALANCE");
	       System.out.println("------------------------------");
	       for (Bank searchaccount : accounts) {
	    	   System.out.println(searchaccount);
	       }
	       adminMainMenu();
	       break;
	case 4:System.out.println("Which account do you want to delete ?");
		   dao.deleteAccount(s.nextInt());
		   adminMainMenu();
		   break;
	case 5:BankManagementSystem.main(null);
	       break;
	 default:System.out.println("enter the value range between 1-5 only");
	}
}
	public static void customerMainMenu() {
		System.out.println("-----------------------");
		System.out.println("1.DEPOSIT              ");
		System.out.println("2.WITHDRAW             ");
		System.out.println("3.CHECK BALANCE        ");
		System.out.println("4.BACK                 ");
		System.out.println("-----------------------");
		System.out.println("enter your choice");
		Scanner s=new Scanner(System.in);
		int choice=s.nextInt();
		switch(choice){
		case 1:dao.deposit();
		       customerMainMenu();
		       break;
		case 2:dao.withdraw();
		       customerMainMenu();
	           break;
		case 3:dao.checkBalance();
		       customerMainMenu();
		       break;
		case 4:BankManagementSystem.main(null);
	           break;
	    default:System.out.println("enter valid number between 1-4 only");
		
		}
	}

	
}
