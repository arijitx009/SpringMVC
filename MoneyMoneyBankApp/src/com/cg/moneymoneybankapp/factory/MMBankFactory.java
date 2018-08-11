//This class implements the class BankFactory.
//It overrides the the methods createNewCurrentAccount() and createNewSavingsAccount() of class BankFactory.

package com.cg.moneymoneybankapp.factory;

import java.time.LocalDate;
import java.util.Map;
import com.cg.bank.framework.account.pojo.CurrentAccount;
import com.cg.bank.framework.account.pojo.SavingsAccount;
import com.cg.bank.framework.factory.BankFactory;
import com.cg.moneymoneybankapp.account.pojo.MMBankCurrentAccount;
import com.cg.moneymoneybankapp.account.pojo.MMBankCustomer;
import com.cg.moneymoneybankapp.account.pojo.MMBankCustomerAddress;
import com.cg.moneymoneybankapp.account.pojo.MMBankSavingsAccount;

public class MMBankFactory extends BankFactory {
	
	MMBankCurrentAccount mmBankCurrentAccount;
	MMBankSavingsAccount mmBankSavingAccount;
	MMBankCustomer mmBankCustomer;
	MMBankCustomerAddress mmBankCustomerAddress;

	@Override
	public CurrentAccount createNewCurrentAccount(Map<String, Object> map) {
		mmBankCustomerAddress = new MMBankCustomerAddress(map.get("houseNo").toString(), map.get("street").toString(),
				map.get("city").toString(), map.get("state").toString(), (int) map.get("pinCode"));

		mmBankCustomer = new MMBankCustomer(map.get("accountHolderName").toString(), (long) map.get("contactNumber"),
				(LocalDate) map.get("dateOfBirth"), mmBankCustomerAddress, map.get("nationality").toString(),
				map.get("gender").toString());

		mmBankCurrentAccount = new MMBankCurrentAccount(mmBankCustomer, (double) map.get("accountBalance"),
				(double) map.get("odLimit"));
		return mmBankCurrentAccount;
	}

	@Override
	public SavingsAccount createNewSavingsAccount(Map<String, Object> map) {

		if ((boolean) map.get("salary") == true) {

			mmBankCustomerAddress = new MMBankCustomerAddress(map.get("houseNo").toString(),
					map.get("street").toString(), map.get("city").toString(), map.get("state").toString(),
					(int) map.get("pinCode"));

			mmBankCustomer = new MMBankCustomer(map.get("accountHolderName").toString(),
					(long) map.get("contactNumber"), (LocalDate) map.get("dateOfBirth"), mmBankCustomerAddress,
					map.get("nationality").toString(), map.get("gender").toString());

			mmBankSavingAccount = new MMBankSavingsAccount(mmBankCustomer, (boolean) map.get("salary"));
		} else {
			mmBankCustomerAddress = new MMBankCustomerAddress(map.get("houseNo").toString(),
					map.get("street").toString(), map.get("city").toString(), map.get("state").toString(),
					(int) map.get("pinCode"));

			mmBankCustomer = new MMBankCustomer(map.get("accountHolderName").toString(),
					(long) map.get("contactNumber"), (LocalDate) map.get("dateOfBirth"), mmBankCustomerAddress,
					map.get("nationality").toString(), map.get("gender").toString());

			mmBankSavingAccount = new MMBankSavingsAccount(mmBankCustomer, (double) map.get("accountBalance"),
					(boolean) map.get("salary"));

		}

		return mmBankSavingAccount;
	}

}
