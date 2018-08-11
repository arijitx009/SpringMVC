//this account extends the BankAccount .
//It has the specific instances Specific to the Saving account and their setters and getters.

package com.cg.bank.framework.account.pojo;

public abstract class SavingsAccount extends BankAccount {
	private boolean salary;

	//Constructor For Non-Zero balance. 
	public SavingsAccount(Customer accountHolder, double accountBalance, boolean salary) {
		super(accountHolder, accountBalance);
		this.salary = salary;
	}
	
	//Constructor for Zero balance Account.
	public SavingsAccount(Customer accountHolder, boolean salary) {
		super(accountHolder);
		this.salary = salary;
	}

	public boolean isSalary() {
		return salary;
	}
	public void setSalary(boolean salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
}
