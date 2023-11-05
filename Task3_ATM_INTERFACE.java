package OIBSIP;


import java.util.HashMap;
import java.util.Scanner;

public class Task3_ATM_INTERFACE{

	public static void main(String[] args) {
		// install machine
		//creating object of class Atm_opn

		Atm_opn obj = new Atm_opn();
	}
}
class Data{
	//variables
	float  Balance;
	String name;
	int pin;
	int transactions = 0;
	String transactionHistory = "";
	
}

class Atm_opn{
	
	Scanner sc = new Scanner(System.in);

	HashMap<String, Data> map =new HashMap<>();
	
	Atm_opn(){
		//constructor
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("\tOrganization for the Advancement of Structured Information Standards Bank");
		System.out.println("-------------------------------------------------------------------------------------------\n\n");
		System.out.println("\t\t\t\tWelcome to OASIS Bank");
		opn();
	}
	
	public void opn()
	{
		
		System.out.print("Enter your Account Number: ");
		String AccountNo = sc.next();
		try
		{
			if (map.containsKey(AccountNo)==true)
			{
				Data obj1 = map.get(AccountNo);
				Menu(obj1);
			}
		else
			{
			
			System.out.println("Account Does not exist");
			System.out.println("-------------------------------------------------------------------------------------------\n\n");
			System.out.println("Kindly, create Bank Account first\n");
			System.out.print("Set your Bank Account Number: ");
			String AccNumber = sc.next();
			
			Data obj = new Data();
			map.put(AccNumber, obj);
			
			System.out.print("Enter your Name: ");
			obj.name = sc.next();
			
			System.out.print("Set your 4 digit pin : ");
			obj.pin = sc.nextInt();
			
			Menu(obj);
			}
		}
		catch ( Exception e) {
		}
		}
	
	public void Menu(Data obj) {
		System.out.println("\n\n-------------------------------------------------------------------------------------------");

		System.out.println("Please Select valid number ");
		
		System.out.println("1 . Check balance");
        System.out.println("2 . Deposit money");
        System.out.println("3 . Withdraw money");
        System.out.println("4 . Check another account");
        System.out.println("5 . Transfer money");
        System.out.println("6 . Transaction history");
        System.out.println("7 . exit");
		System.out.println("-------------------------------------------------------------------------------------------\n");

        System.out.print("Enter your choice: ");
		int ch = sc.nextInt();
		System.out.println("");
		
		switch (ch)
		{
		case 1:
		{
			check_Balance(obj);
			break;
		}
		case 2:
		{
			deposit(obj);
			break;
		}
		case 3:
		{
			withdraw(obj);
			break;
		}
		case 4:
		{
			opn();
			break;
		}
		case 5:
		{
			transfer(obj);
			break;
		}
		case 6:
		{
			transferHistory(obj);
			break;
		}
		case 7:
		{
			System.out.println("Thank you for using OASIS ATM!");
			break;
		}
		default:
		{
			System.out.println("Please enter valid number: ");
			Menu(obj);
		}
		}
	}
	
		public void check_Balance(Data obj)
		{
			System.out.println("Your Bank Balance is: "+ obj.Balance);
			Menu(obj);
		}
		
		public void deposit(Data obj)
		{
			System.out.print("Enter your amount to deposit: ");
			float a = sc.nextFloat();
			
			try
			{
			obj.Balance = obj.Balance +a;
			System.out.println("Amount deposited succesfully");
			String str = a + " Rs deposited\n";
			obj.transactionHistory = obj.transactionHistory.concat(str);
			obj.transactions++;
			Menu(obj);
			}
			catch ( Exception e) {
			}
		}
		
		public void withdraw(Data obj)
		{
			System.out.print("Enter your amount to withdraw: ");
			float w = sc.nextFloat();
			
			try
			{
			if(obj.Balance>= w)
			{
				obj.Balance = obj.Balance -w;
				System.out.println("Amount withdrawn succesfully");
				String str = w + " Rs Withdrawn\n";
				obj.transactionHistory = obj.transactionHistory.concat(str);
				obj.transactions++;
			}
			else
			{
				System.out.println("Insufficient Balance\nEnter a valid number to withdraw\n");
				withdraw(obj);
			}
			}
			catch ( Exception e) {
			}
			
			Menu(obj);
		}
		
		public void transfer(Data obj) {
			System.out.println("Enter amount to tranfer");
			float trans = sc.nextFloat();
			
			try
			{
				if(trans==0)
				{
					System.out.println("Transfer amount cannot be Null/0");
				}
		
			if(obj.Balance>= trans)
			{
				obj.Balance = obj.Balance -trans;
			}
			else
			{
				System.out.println("Insufficient Balance");
				transfer(obj);
			}
			}
			catch ( Exception e) {
			}
			Amount_transfer(trans);
	}
		
		public void Amount_transfer(float trans)
		{
			System.out.print("Enter Account Number of the recipient to transfer amount: ");
			String AccountNo = sc.next();
			
			try
			{
				if (map.containsKey(AccountNo)==true)
			{
				Data obj = map.get(AccountNo);

				obj.Balance = obj.Balance +trans;
				System.out.println("Amount transfer succesfully to "+ obj.name);
				obj.transactions++;
				String str = trans + " Rs transfered to " + obj.name +"\n";
				obj.transactionHistory = obj.transactionHistory.concat(str);
				
				Menu(obj);
			}
			else {
				System.out.println("Account of the recipient does not exist");

				System.out.println("Kindly, create Bank Account first\n");
				
				System.out.print("Set your Bank Account Number: ");
				String AccNumber = sc.next();
				
				Data obj = new Data();
				map.put(AccNumber, obj);
				
				System.out.print("Enter your Name: ");
				obj.name = sc.next();
				
				System.out.print("Set your 4 digit pin : ");
				obj.pin = sc.nextInt();
				
				obj.Balance = obj.Balance +trans;
				System.out.println("Amount transfer succesfully");
				obj.transactions++;
				String str = trans + " Rs transfered to " + obj.name +"\n";
				obj.transactionHistory = obj.transactionHistory.concat(str);
				Menu(obj);
			}
			}
			catch ( Exception e) {
			}
		}
			
		public void transferHistory(Data obj) {
			if ( obj.transactions == 0 ) {
				System.out.println("\n You had no transations.");
				Menu(obj);
			}
			else {
				System.out.println("\n" + obj.transactionHistory);
				Menu(obj);
			}
		}
		
}