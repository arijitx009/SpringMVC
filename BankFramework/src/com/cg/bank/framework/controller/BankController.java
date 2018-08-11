//This class will act as an abstract controller class for the implementing  banks. 
package com.cg.bank.framework.controller;

import java.util.Collection;
import java.util.Map;

import com.cg.bank.framework.account.pojo.BankAccount;
import com.cg.bank.framework.account.pojo.Customer;

public abstract class BankController {
	
	public abstract void createNewSavingsAccount(Map<String, Object> account);

	public abstract void createNewCurrentAccount(Map<String, Object> account);
	
	public double getCurrrentBalance(BankAccount bankAccount) {
		return bankAccount.getAccountBalance();
	}
	
	public int getNextAccountNumber() {
		return BankAccount.getNextAccountNumber();
	}
	
	public abstract Collection<BankAccount> getAllAccounts();
	
	public abstract Collection<Customer> getAllCustomers();
	
}
