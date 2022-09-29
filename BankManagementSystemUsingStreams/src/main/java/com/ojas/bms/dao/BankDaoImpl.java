package com.ojas.bms.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.ojas.bms.model.Bank;

class InsufficientFundsException extends RuntimeException {
	InsufficientFundsException(String msg) {
		super(msg);
	}
}

public class BankDaoImpl implements BankDao {
	public static List<Bank> originalList = new ArrayList<Bank>();
	public static List<Bank> tempList = new ArrayList<Bank>();
	Scanner s = new Scanner(System.in);
	Bank bank = null;
	int count = 0;

	public void currentAccount()  {
		int n = 1;
		while (n == 1) {
			bank = new Bank();

			// Bank bank1=new Bank(1234,"sr",7689,1000);

			System.out.println("your account type is:current account");
			System.out.println("enter account name");
			String name = s.next();
			while (!Pattern.matches("[A-Z][a-z]*", name)) {
				System.out.println("enter characters only with first character as capital letter");
				name = s.next();
			}
			bank.setAccountHolderName(name);
			System.out.println("enter account number");
			bank.setAccountNum(s.nextInt());
			System.out.println("enter mobile number");
			String number = s.next();
			while (!Pattern.matches("[0-9]{10}", number)) {
				System.out.println("enter your 10-digits mobile number   ");
				number = s.next();
			}
			long mobNum = Long.parseLong(number);
			bank.setMobileNum(mobNum);
			System.out.println("Do you want to add more products press 1 else any number");
			n = s.nextInt();
			originalList.add(bank);
			
			 //originalList.add(bank1);

			System.out.println("total accounts you have added " + (++count));
		}
		System.out.println("account added successfully");
	}

	public void savingsAccount() {
		int n = 1;
		while (n == 1) {
			bank = new Bank();
			System.out.println("your account type is:savings account");
			System.out.println("enter account name");
			String name = s.next();
			while (!Pattern.matches("[A-Z][a-z]*", name)) {
				System.out.println("enter characters only with first character as capital letter");
				name = s.next();
			}
			bank.setAccountHolderName(name);
			System.out.println("enter account number");
			bank.setAccountNum(s.nextInt());
			String number = s.next();
			while (!Pattern.matches("[0-9]{10}", number)) {
				System.out.println("enter your 10-digits mobile number   ");
				number = s.next();
			}
			long mobNum = Long.parseLong(number);
			bank.setMobileNum(mobNum);
			System.out.println("Do you want to add more products press 1 else any number");
			n = s.nextInt();
			originalList.add(bank);
			System.out.println("total accounts you have added " + (++count));
		}

	}

	public List<Bank> searchAccount(int accountNum) {
		List<Bank> account1= originalList.stream().filter(account->account.getAccountNum()==accountNum)
				                                  .collect(Collectors.toList());
		return account1;
	}

	public List<Bank> viewAllAccounts() {
		return originalList;

	}

	public void deleteAccount(int accountNum) {
		tempList = new ArrayList<Bank>();
		tempList = originalList.stream().filter(account -> account.getAccountNum() != accountNum)
				                        .collect(Collectors.toList());
		originalList = new ArrayList<Bank>();
		for (Bank updateAccount : tempList) {
			originalList.add(updateAccount);
		}
		System.out.println("Account deleted successfully....");

	}

	public void deposit() {
		System.out.println("enter account number");
		long accountNum = s.nextLong();

		tempList = new ArrayList<Bank>();
		for (Bank updateAccount : originalList) {
			if (updateAccount.getAccountNum() == accountNum) {
				System.out.println("enter the money you want to deposit");
				int money = s.nextInt();
				double balance = updateAccount.getBalance() + money;

				updateAccount.setBalance(balance);
			}
			tempList.add(updateAccount);
		}

		originalList = new ArrayList<Bank>();
		originalList=tempList.stream().collect(Collectors.toList());
		}

	public void withdraw() {
		System.out.println("enter account number");
		long accountNum = s.nextLong();

		tempList = new ArrayList<Bank>();
		for (Bank updateAccount : originalList) {
			if (updateAccount.getAccountNum() == accountNum) {
				System.out.println("enter the money you want to withdraw");
				int money = s.nextInt();

				double balance = updateAccount.getBalance();
				if (balance != 0) {
					if(balance>money){
					balance -= money;
					updateAccount.setBalance(balance);}
					else
						try {
							throw new InsufficientFundsException("you have insufficient balance");
						} catch (Exception e) {
							
							System.out.println("you have insufficient funds");
						}
				} else
					try {
						throw new InsufficientFundsException("you have zero balance");
					} catch (Exception e) {
						System.out.println(
								"you have zero balance .Please check the balance before withdrawing the money.");

					}
			}
			tempList.add(updateAccount);
		}
		originalList = new ArrayList<Bank>();
		originalList=tempList.stream().collect(Collectors.toList());
	}

	public void checkBalance() {
		System.out.println("enter account number");
		long accountNum = s.nextLong();
		originalList.stream().filter(account->account.getAccountNum()==accountNum)
		                     .forEach(account -> System.out.println(account.getBalance()));
		

	}
}
