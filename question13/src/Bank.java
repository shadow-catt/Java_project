import java.io.*;
import java.util.ArrayList;

public class Bank implements Serializable {
	//variable
	private String name;
	private ArrayList<IAccount> accounts;
	private ArrayList<ModelListener> listeners;
	private File file;
	
	//history integer
	private ArrayList<Integer> history;
	
	//initial value
	public Bank(String name) {
		this.name=name;
		listeners = new ArrayList<ModelListener>();
		//Initialize
		file = new File(this.name + ".bin");
		if(!file.exists()) {
			// then create it
			//let it be empty
			accounts=new ArrayList<IAccount>();
			//create an array list with 0 initially
			history=new ArrayList<Integer>(0);
			history.add(0);
		}
		else {
			FileInputStream fi;
			try {
				//read it as binary
				fi = new FileInputStream(file);
				//let the original data Serializable
				ObjectInputStream in=new ObjectInputStream(fi);
				
				//read it to the original data
				//Cast is mandatory
				ArrayList<IAccount> a=(ArrayList<IAccount>)in.readObject();
				ArrayList<Integer> h=(ArrayList<Integer>)in.readObject();

				//put it into corresponding arrayList
				this.accounts=a;
				this.history=h;

				//close
				fi.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.exit(1);
				
			}catch(ClassNotFoundException e) {
				//if the class not exist
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				System.exit(1);
			}			
		}

		}

	//function
	public void addAccount(IAccount account) {
		accounts.add(account);
		//add the total money
		history.add(totalMoney());
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
				//add the total money
				history.add(totalMoney());
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
	
	//get history function
	public ArrayList<Integer> getHistory(){
		return history;
	}
	
	//save data
	public void saveData() {
		//write it
		try {
			//output binary data
			FileOutputStream fo=new FileOutputStream(this.name+".bin");
			//output an object
			ObjectOutputStream out= new ObjectOutputStream(fo);
			//write account and history into the binary file
			out.writeObject(accounts);
			out.writeObject(history);
			out.close();
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
