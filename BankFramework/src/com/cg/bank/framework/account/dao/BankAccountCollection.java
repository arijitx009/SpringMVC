//This abstract  class will acts as parent class  for the DAO for various banks. 

package com.cg.bank.framework.account.dao;
import java.util.Set;
import java.util.TreeSet;

import com.cg.bank.framework.account.pojo.BankAccount;


public abstract class BankAccountCollection {
	private static Set<BankAccount> bankAccountSet;
	
	static {
		bankAccountSet = new TreeSet<>();
	}
	
	/**
	 * @param bankAccount
	 * 
	 * This method takes account object and adds it in the database
	 */
	public void addBankAccount(BankAccount bankAccount) {
		bankAccountSet.add(bankAccount);
	}
	
	/**
	 * @return Set of Accounts
	 * 
	 * This method is responsible for returning all the active accounts
	 */
	public static Set<BankAccount> viewAll(){
		return bankAccountSet;
	}
}
