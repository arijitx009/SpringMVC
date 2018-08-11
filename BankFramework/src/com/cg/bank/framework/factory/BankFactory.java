//This class is the abstraction for all the Object creation by any implementing bank. 
//This abstract class has two basic methods that needs to implemented by the inheriting class. 
package com.cg.bank.framework.factory;

import java.util.Map;

import com.cg.bank.framework.account.pojo.CurrentAccount;
import com.cg.bank.framework.account.pojo.SavingsAccount;

public abstract class BankFactory {

	public abstract SavingsAccount createNewSavingsAccount(Map<String, Object> account);

	public abstract CurrentAccount createNewCurrentAccount(Map<String, Object> account);

}
