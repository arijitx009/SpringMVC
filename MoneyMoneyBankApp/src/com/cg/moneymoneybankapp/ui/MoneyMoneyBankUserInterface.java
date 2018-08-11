//User Interface for user to provide Input 

package com.cg.moneymoneybankapp.ui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bank.framework.account.pojo.BankAccount;
import com.cg.bank.framework.account.pojo.Customer;
import com.cg.moneymoneybankapp.controller.MoneyMoneyBankController;

public class MoneyMoneyBankUserInterface {

	private static Scanner scanner = new Scanner(System.in);
	private static Map<String, Object> accountDetails = new HashMap<>();
	
	private static Collection<BankAccount> listOfAllAccounts = new TreeSet<BankAccount>();
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("MMBank.xml");
	private static MoneyMoneyBankController mmBankController = (MoneyMoneyBankController) context.getBean("MController");
	
	public static void start() throws IOException {
		while (true) {
			showMenu();
		}
	}

	private static void showMenu() throws IOException {
		System.out.println("Make Choice : ");
		System.out.println("1. Add New Savings Account");
		System.out.println("2. Add New Current Account");
		System.out.println("3. See All Accounts List");
		System.out.println("4. See All Customer List");
		System.out.println("5. Get Next Accountn Number");
		System.out.println("6. Search Account By Account Number");
		System.out.println("7. Deposit Amount");
		System.out.println("8. WithDarw Amount");
		System.out.println("9. Perform Fund Transfer");
		System.out.println("10. Exit");

		acceptChoice();

	}

	private static void acceptChoice() throws IOException {

		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			addNewSavingsAccount();
			break;
		case 2:
			addNewCurrentAccount();
			break;
		case 3:
			showAllAccountList();
			break;
		case 4:
			showAllCustomer();
			break;
		case 5:
			showNextAccountNumber();
			break;
		case 6:
			searchAccountByAccountNumber();
			break;
		case 7:
			depositAmount();
			break;
		case 8:
			withdrawAmount();
			break;
		case 9:
			doFundTransfer();
			break;
		case 10:
			System.exit(0);
			break;
		default:
			System.out.println("Enter a Valid Choice");
		}
	}

	private static void doFundTransfer() {
		System.out.println("Enter the Recipient Account number");
		int receipientAccountNumber = scanner.nextInt();
		
		System.out.println("Enter the Doner Account number");
		int donerAccountNumber = scanner.nextInt();
		
		System.out.println("Enter the amount to be transffered");
		double amountToBeTransffered = scanner.nextDouble();
		
		mmBankController.performFundTransfer(receipientAccountNumber,donerAccountNumber,amountToBeTransffered);
	}

	private static void withdrawAmount() {
		System.out.println("Enter the Account Number");
		int accountToDeductedFrom = scanner.nextInt();
		System.out.println("Enter the Amount ");
		double amount = scanner.nextDouble();
		mmBankController.withdrawAmountFromAccount(accountToDeductedFrom ,amount);
		
	}

	private static void depositAmount() {
		System.out.println("Enter the account number");
		int accountToBeDepositedIn = scanner.nextInt();
		
		System.out.println("Enter the amount to be deposited");
		double amount = scanner.nextDouble();
		
		mmBankController.depositAmountIntoAccount(accountToBeDepositedIn,amount);
		
	}

	private static void showAllCustomer() {
		for(Customer customer : mmBankController.getAllCustomers()){
			System.out.println(customer);
		}
	}

	private static void searchAccountByAccountNumber() throws IOException {
		System.out.println("Enter the account number");
		int accountNumber = scanner.nextInt();
		System.out.println(mmBankController.getAccountByAccountNumber(accountNumber));
	}

	private static void showNextAccountNumber() {
		System.out.println(mmBankController.getNextAccountNumber());
	}

	private static void showAllAccountList() {
		listOfAllAccounts = mmBankController.getAllAccounts();
		
		for(BankAccount bankAccount : listOfAllAccounts) {
			System.out.println(bankAccount);
		}
	}

	private static void addNewCurrentAccount() throws IOException {

		System.out.println("Enter Account Holder Name: ");
		String accountHolderName = scanner.next();
		accountDetails.put("accountHolderName", accountHolderName);
		
		System.out.println("Enter Account Balance: ");
		double accountBalance = scanner.nextDouble();
		accountDetails.put("accountBalance", accountBalance);
		
		System.out.println("Enter overDraft limit: ");
		double odLimit = scanner.nextDouble();
		accountDetails.put("odLimit",odLimit);
		acceptCustomerDetails();
		
		acceptCustomerAddress();
		
		mmBankController.createNewCurrentAccount(accountDetails);
	}

	private static void addNewSavingsAccount() throws IOException {

		System.out.println("Enter Account Holder Name: ");
		String accountHolderName = scanner.next();
		accountDetails.put("accountHolderName", accountHolderName);
		
		System.out.println("Enter Salary?(n/y): ");
		String salary = scanner.next();
		accountDetails.put("salary", salary.equalsIgnoreCase("n")?false:true);
		
		if(salary.equalsIgnoreCase("n")){
		System.out.println("Enter Account Balance: ");
		double accountBalance = scanner.nextDouble();
		accountDetails.put("accountBalance", accountBalance);
		}
		acceptCustomerDetails();
		
		acceptCustomerAddress();
		
		mmBankController.createNewSavingsAccount(accountDetails);
	}

	private static void acceptCustomerAddress() {
		System.out.println("Enter Your House Number");
		String houseNo = scanner.next();
		accountDetails.put("houseNo", houseNo);
		
		System.out.println("Enter the Street number");
		String street = scanner.next();
		accountDetails.put("street", street);
		
		System.out.println("Enter the city");
		String city = scanner.next();
		accountDetails.put("city", city);
		
		System.out.println("Enter the State");
		String state = scanner.next();
		accountDetails.put("state", state);
		
		System.out.println("Enter the pinCode");
		int pinCode = scanner.nextInt();
		accountDetails.put("pinCode", pinCode);
	}

	private static void acceptCustomerDetails() throws IOException {
		System.out.println("Enter Contact Number: ");
		Long contactNumber =scanner.nextLong();
		accountDetails.put("contactNumber", contactNumber);
		
		System.out.println("Enter Date of Birth(dd/mm/yyyy): ");
		String dobStr =scanner.next();
		LocalDate dateOfBirth = getDate(dobStr);
		accountDetails.put("dateOfBirth", dateOfBirth);
		
		System.out.println("Enter the Gender");
		String gender = scanner.next();
		accountDetails.put("gender", gender);
		
		System.out.println("Enter the nationality");
		String nationality = scanner.next();
		accountDetails.put("nationality", nationality);
	}

	
	private static LocalDate getDate(String dobStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dobStr, formatter);
		return date;
	}
}
