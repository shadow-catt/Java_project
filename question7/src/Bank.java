import java.util.ArrayList;

public class Bank {
	//variable
	private String name;
	private ArrayList<IAccount> accounts;
	private ArrayList<ModelListener> listeners;
	//initial value
	public Bank(String name) {
		this.name=name;
		accounts = new ArrayList<IAccount>();
		listeners = new ArrayList<ModelListener>();
	}
	//function
	public void addAccount(IAccount account) {
		accounts.add(account);
		notifyListeners();
	}
	public int totalMoney() {
		int total = 0;
		for(IAccount i:accounts) {
			total+=i.getMoney();
		}
		return total;
	}
	public int getMoney(String name) throws UnknownCustomerException {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getName().equals(name)) {
				return accounts.get(i).getMoney();
			}
		}
		throw new UnknownCustomerException("Customer "+ name +" unknown");
	}
	public void withdraw(String name,int amount) throws UnknownCustomerException, NotEnoughMoneyException {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getName().equals(name)) {
				accounts.get(i).withdraw(amount);
				notifyListeners();
				return;
			}
		}
		throw new UnknownCustomerException("Customer "+ name +" unknown");
	}
	
	
	//add listener
	public void addListener(ModelListener l) {
		listeners.add(l);
	}
	
	//notify Listener
	private void notifyListeners() {
		for(ModelListener l: listeners) {
			l.update();
		}
	}
	
	//test code
	public static void testBank() {
		Bank b = new Bank("Justin");
		try {
			StudentAccount s1 = new StudentAccount("Jack",10);
			b.addAccount(s1);
			//test get money function
			try {
				b.getMoney("Franklin");
			}
			catch(UnknownCustomerException e){
				System.out.println(e.getMessage().equals("Customer Franklin unknown"));
			}
			try {
				System.out.println(b.getMoney("Jack")==10);
			}
			catch(UnknownCustomerException e) {
			}
			
			//test withdraw for wrong name
			try {
				b.withdraw("Franklin", 10);
			}
			catch(UnknownCustomerException e) {
				System.out.println(e.getMessage().equals("Customer Franklin unknown"));
			}
			catch(NotEnoughMoneyException e) {
			}
			//test withdraw for not enough money
			try {
				b.withdraw("Jack", 40);
			}
			catch(UnknownCustomerException e) {
			}
			catch(NotEnoughMoneyException e) {
				System.out.println(e.getMessage().equals("Cannot withdraw 40 yuan from account, only 10 yuan is available"));
			}
			//common test 
			try {
				b.withdraw("Jack", 5);
			}
			catch(UnknownCustomerException e) {
			}
			catch(NotEnoughMoneyException e) {
			}
			try {
				System.out.println(b.getMoney("Jack")==5);
			}
			catch(UnknownCustomerException e) {
			}
		}
		catch (NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
		}
	}
}
