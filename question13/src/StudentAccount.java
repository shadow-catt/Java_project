
public class StudentAccount extends Account{
	//initial value
	public StudentAccount(String name,int money) throws NotEnoughMoneyException{
		super(name,money);
		if(money<0) {
			throw new NotEnoughMoneyException("Cannot create student account with negative amount of money");
		}
	}
	//withdraw function
	@Override
	public void withdraw(int amount) throws NotEnoughMoneyException{
		// TODO Auto-generated method stub
	if(amount<=this.getMoney())
		setMoney(getMoney()-amount);
	else
		throw new NotEnoughMoneyException("Cannot withdraw "+ amount +" yuan from account, only "+ this.getMoney() +" yuan is available");
	}
	
	//test code
	public static void testStudentAccount() {
		//new a students with negative account
		try {
			StudentAccount s1 = new StudentAccount("Jack",-10);
		}
		catch(NotEnoughMoneyException e) {
			System.out.println(e.getMessage().equals("Cannot create student account with negative amount of money"));
		}
		try {
			StudentAccount s2 = new StudentAccount("Jace",10);
		    System.out.println(s2.getName().equals("Jace"));
		    System.out.println(s2.getMoney()==10);
			s2.withdraw(5);
			System.out.println(s2.getName().equals("Jace"));
		    System.out.println(s2.getMoney()==5);
		    try {
		    	s2.withdraw(10);
		    }
		    catch(NotEnoughMoneyException e) {
		    	System.out.println(e.getMessage().equals("Cannot withdraw 10 yuan from account, only 5 yuan is available"));
		    }
		}
		catch(NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
		}
	}
}
