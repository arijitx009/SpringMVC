//This is the entry point of the application .
//This class just starts the UserInteface page of the application.

package com.cg.moneymoneybankapp.bootstrap;

import java.io.IOException;

import com.cg.moneymoneybankapp.ui.MoneyMoneyBankUserInterface;

public class BootStrap {

	public static void main(String[] args) {
		try {
			MoneyMoneyBankUserInterface.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
