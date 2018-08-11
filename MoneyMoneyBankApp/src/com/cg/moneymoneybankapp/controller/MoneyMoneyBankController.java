//This class is the controller class for the application.
//This class has various methods that takes the request from the user and directs it to the concerned class.
package com.cg.moneymoneybankapp.controller;

import java.util.Collection;
import java.util.Map;

import com.cg.bank.framework.account.dao.BankAccountCollection;
import com.cg.bank.framework.account.pojo.BankAccount;
import com.cg.bank.framework.account.pojo.Customer;
import com.cg.bank.framework.controller.BankController;
import com.cg.moneymoneybankapp.account.dao.MoneyMoneyBankCollection;
import com.cg.moneymoneybankapp.factory.MMBankFactory;

public class MoneyMoneyBankController extends BankController {

	private MMBankFactory mmBankFactory;
	private MoneyMoneyBankCollection mmBankCollection;
	private BankAccount bankAccount;

	//This method gets called from the context file called MMBank.xml
	public void setMmBankFactory(MMBankFactory mmBankFactory) {
		this.mmBankFactory = mmBankFactory;
	}


	//This method gets called from the context file called MMBank.xml
	public void setMmBankCollection(MoneyMoneyBankCollection mmBankCollection) {
		this.mmBankCollection = mmBankCollection;
	}

	
	//This method creates the new Current Account.
	@Override
	public void createNewCurrentAccount(Map<String, Object> map) {
		bankAccount = mmBankFactory.createNewCurrentAccount(map);
		mmBankCollection.addBankAccount(bankAccount);
	}
	

	//This method creates the new Current Account.
	@Override
	public void createNewSavingsAccount(Map<String, Object> map) {
		bankAccount = mmBankFactory.createNewSavingsAccount(map);
		mmBankCollection.addBankAccount(bankAccount);
	}

	
	//This method serves the request for getting the list of all the accounts.
	@Override
	public Collection<BankAccount> getAllAccounts() {
		return BankAccountCollection.viewAll();
	}

	
	//this method serves the request fro getting the list of all the customers. 
	@Override
	public Collection<Customer> getAllCustomers() {
		return mmBankCollection.getCustomers();
	}

	//This method serves the request of searching an account by accountnumber.
	public BankAccount getAccountByAccountNumber(int accountToBeSearched) {
		return mmBankCollection.getAccountByAccountNumber(accountToBeSearched);
	}

	//This method serves the request for withdrawal of  amount from the given account number.
	public void withdrawAmountFromAccount(int accountToDeductedFrom, double amount) {
		mmBankCollection.withdrawAmount(accountToDeductedFrom,amount);
	}

	//This method serves the request for deposit of  amount into the given account number.	
	public void depositAmountIntoAccount(int accountToBeDepositedIn, double amount) {
		mmBankCollection.depositAmount(accountToBeDepositedIn,amount);
	}


	public void performFundTransfer(int receipientAccountNumber, int donerAccountNumber, double amountToBeTransffered) {
		mmBankCollection.performFundTransfer(receipientAccountNumber,donerAccountNumber,amountToBeTransffered);
	}


}
