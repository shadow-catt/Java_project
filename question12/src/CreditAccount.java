import java.awt.SystemColor;

public class CreditAccount extends Account{
	//initial value
	public CreditAccount(String name,int money) {
		super(name,money);
		}

	//take the money and the money can be negative
	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		setMoney(getMoney()-amount);
	}
	
	//test code
	public static void testCreditAccount() {
		CreditAccount c = new CreditAccount("Jack",20);
		//initial money
		System.out.println(c.getName()=="Jack");
		System.out.println(c.getMoney()==20);
		//withdraw 30
		c.withdraw(30);
		System.out.println(c.getMoney()==-10);
	}
}
