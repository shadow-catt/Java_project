import java.util.*;

public class CLI {
	private static Scanner input = new Scanner(System.in);
	
	//main method
	public static void main(String[] args) {
		//variable
		String toolString;
		int choice;
		String name;
		int money;
		
		//new a bank
		Bank b=new Bank("UIC Bank");
		
		while(true) {
			//menu
			choice = readPosInt("Type an action (total:1 add:2 list:3 withdraw:4 deposit:5 quit:6):");
			
			//switch the choice
			switch(choice) {
			//Action 1: printing the total amount of money stored in the bank.
				case(1):
					System.out.println("Total amount of money in the bank:"+b.totalMoney());
					continue;
				
				//Action 2: adding a new customer account to the bank.	
				case(2):
					choice = readPosInt("Type the account type (credit:1 student:2): ");
					switch(choice) {
					//for credit account
						case(1):
							name = readLine("Enter the name of the customer: ");
							money = readPosInt("Enter the initial amount of money: ");
							b.addAccount(new CreditAccount(name,money));
							System.out.println("Credit account for "+ name +" with "+ money +" yuan has been added");
							break;
					//for student account
						case(2):
							name = readLine("Enter the name of the customer: ");
							money = readPosInt("Enter the initial amount of money: ");
							try {
								b.addAccount(new StudentAccount(name,money));
								System.out.println("Student account for "+ name +" with "+ money +" yuan has been added");
							}
							catch(NotEnoughMoneyException e) {
								System.out.println("BUG! This must never happen!");
								System.exit(1);
							}
							break;
					//for wrong number
						default:
							System.out.println("Unknown type of account!");
							continue;
					}
					continue;
					
				//Action 3: listing the amount of money in the account of a given customer.
				case(3):
					name=readLine("Enter the name of the customer: ");
				try {
					System.out.println(name +" has "+ b.getMoney(name) +" yuan in the bank");
				} 
				catch (UnknownCustomerException e) {
					// TODO Auto-generated catch block
					System.out.println("Customer "+name+" unknown");
				}
					continue;
					
				//Action 4: withdrawing money from the account of a given customer.
				case(4):
					name=readLine("Enter the name of the customer: ");
					money=readPosInt("Enter the amount of money to withdraw: ");
				try {
					b.withdraw(name, money);
				} catch (UnknownCustomerException e) {
					// TODO Auto-generated catch block
					System.out.println("Customer "+name+" unknown");
				} catch (NotEnoughMoneyException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					continue;
					
				//Action 5: depositing money into the account of a given customer.
				case(5):
					name=readLine("Enter the name of the customer: ");
					money=readPosInt("Enter the amount of money to deposit: ");
					try {
						b.withdraw(name, (-1)*money);
					} catch (UnknownCustomerException e) {
						// TODO Auto-generated catch block
						System.out.println("Customer "+name+" unknown");
					} catch (NotEnoughMoneyException e) {
						// TODO Auto-generated catch block
						System.out.println("BUG! This must never happen!");
						System.exit(1);
					}
					continue;
				//Action 6: quitting the program.
				case(6):
					System.out.println("Goodbye!");
					System.exit(0);
					break;
				default:
					System.out.println("Unknown action!");
					continue;	
			}
		}
	}
	
	//read a line
	private static String readLine(String a_in) {
		//set the argument for out
		String a_out = null;
		System.out.print(a_in);
		//read the input
		a_out = input.nextLine();
		return a_out;
	}
	private static int readPosInt(String a_in) {
		//local variable
		int judge = 1;
		int i_out=0;
		String temp;
		while(judge==1) {
			System.out.print(a_in);
			//read the input
			try {
				i_out = input.nextInt();
				//judge if positive
				if(i_out >= 0) {
					//if the positive int is read successfully, i will be set to 0 to break the loop
					judge=0;
				}
				else
					//if not positive, which means the function have not return
					System.out.println("Positive integers only!");
			}
			catch(InputMismatchException e) {
				System.out.println("You must type an integer!");
			}
			finally {
				temp = input.nextLine();
			}
		}
		return i_out;
	}
}
