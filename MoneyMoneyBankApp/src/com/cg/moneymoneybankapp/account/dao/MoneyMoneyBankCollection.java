//This class extends the BankAccountCollection .
//It also defines various methods specific to the Money money bank.
package com.cg.moneymoneybankapp.account.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cg.bank.framework.account.dao.BankAccountCollection;
import com.cg.bank.framework.account.pojo.BankAccount;
import com.cg.bank.framework.account.pojo.Customer;

public class MoneyMoneyBankCollection extends BankAccountCollection {

	// This method removes the bank bank account from the Database.
	public void removeBankAccountByAccountNumber(int accountNumberToBeRemoved) {
		for (BankAccount bankAccount : BankAccountCollection.viewAll()) {
			if (bankAccount.getAccountNumber() == accountNumberToBeRemoved) {
				BankAccountCollection.viewAll().remove(bankAccount);
				break;
			}
		}
	}

	// It fetches the account by the account number.
	public BankAccount getAccountByAccountNumber(int accountToBeSearched) {
		for (BankAccount bankAccount : BankAccountCollection.viewAll()) {
			if (bankAccount.getAccountNumber() == accountToBeSearched) {
				return bankAccount;
			}
		}
		return null;
	}

	// it fetches the customer list associated with the MMBank
	public Collection<Customer> getCustomers() {
		List<Customer> listOfCustomer = new ArrayList<Customer>();
		for (BankAccount s : viewAll()) {
			listOfCustomer.add(s.getAccountHolder());
		}
		return listOfCustomer;
	}

	// It uses the withdraw() method of the BankAccount and performs the withdrawal
	// action on a given account.
	public void withdrawAmount(int accountToDeductedFrom, double amount) {
		for (BankAccount b : viewAll()) {

			if ((b.getAccountNumber() == accountToDeductedFrom)) {
				b.withdraw(amount);
			}
		}
	}

	// It uses the deposit() method of the BankAccount and performs the deposit
	// action on a given account.
	public void depositAmount(int accountToBeDepositedIn, double amount) {
		for (BankAccount b : viewAll()) {
			if ((b.getAccountNumber() == accountToBeDepositedIn)) {
				b.deposit(amount);
			}
		}

	}

	public void performFundTransfer(int receipientAccountNumber, int donerAccountNumber, double amountToBeTransffered) {
		
		for(BankAccount receiver : viewAll() ) {
			if(receiver.getAccountNumber() == receipientAccountNumber) {
				for(BankAccount sender : viewAll() ) {
					if(sender.getAccountNumber() == donerAccountNumber) {
						receiver.deposit(sender.withdraw(amountToBeTransffered));
					}
				}
			}
		}
	}

}
