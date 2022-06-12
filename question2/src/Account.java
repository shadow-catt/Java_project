
public abstract class Account implements IAccount{
	//variable
	private String name;
	private int money;
	
	//initial value
	public Account(String name,int money) {
		this.name=name;
		this.money=money;
	}
	
	//method from the interface
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return this.money;
	}

	@Override
	public abstract void withdraw(int amount);
	
	//setMoney
	protected void setMoney(int money) {
		this.money=money;
	}
	
	//test code
	public static void testAccount() {
		//since it is an abstract class, it have no test code
	}
}
