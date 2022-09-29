package com.ojas.bms.dao;

import java.util.List;

import com.ojas.bms.model.Bank;

public interface BankDao {
	   public void currentAccount();
	   public void savingsAccount();
	   public List<Bank> searchAccount(int accountNum);
	   public List<Bank> viewAllAccounts();
	   public void deleteAccount(int accountNum);
	   public void deposit();
	   public void withdraw();
	   public void checkBalance();
}
