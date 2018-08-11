//This class maintains the Customer details of a bank.
//It extends the Customer and just calls the parent class constructor using super keyword.
package com.cg.moneymoneybankapp.account.pojo;

import java.time.LocalDate;

import com.cg.bank.framework.account.pojo.Customer;

public class MMBankCustomer extends Customer {

	public MMBankCustomer(String customerName, long contactNumber, LocalDate dateOfBirth,
			MMBankCustomerAddress permanentAddress, String nationality, String gender) {
		super(customerName, contactNumber, dateOfBirth, permanentAddress, nationality, gender);
	}

}
