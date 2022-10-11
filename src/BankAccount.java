import java.util.Scanner;

public class BankAccount {
	private String name = "";
	private int id = 0;
	Scanner console = new Scanner (System.in);
	double amount = 0.00;
	double balance = 0.00;
	
	BankAccount (String name, int id) {
		this.name = name;
		this.id = id;
	}

	public void welcome() {
		System.out.println("Welcome " + name + "!\nYour customer ID is " + id + "\n");
		showMenu();
	}
	
	public void showMenu(){
		System.out.println("Please Select A Service:\nA: Deposit\nB: Withdraw\nC: Previous Transaction\nD: Balance\nE: Exit\n");
		String option = console.next();
		option = option.toUpperCase();
	}
	
	public void deposit() {
		System.out.println("How much would you like to deposit?\n");
		amount = console.nextDouble();
		balance += amount;
		System.out.print("Amount deposited: $" + String.format("%.2f",amount) + "\n");
		showMenu();
	}
	
	public void withdraw() {
		System.out.println("How much would you like to withdraw?\n");
		amount = console.nextDouble();
		if (amount <= balance) {
			balance -= amount;
			System.out.print("Amount withdrawn: $" + String.format("%.2f",amount) + "\n");
			amount = -amount;
			showMenu();	
		} else {
			System.out.print("Not enough balance to withdraw this amount");
			showMenu();
		}
	}
	
	public void balance() {
		System.out.println("Current balance: $" + String.format("%.2f",balance) + "\n");
		showMenu();
	}
	
	public void previousTransaction() {
		if (amount < 0) {
			amount = Math.abs(amount);
			System.out.println("Previous transaction: Withdrew $" + String.format("%.2f",amount) + "\n");
		} else if (amount == 0) {
			System.out.println("No previous transaction");
		} else {
			System.out.println("Previous transaction: Deposited $" + String.format("%.2f",amount) + "\n");
		}
		showMenu();
	}
	
	public void exit() {
		System.out.println("Thank you, have a nice day " + name + "!");
	}
}