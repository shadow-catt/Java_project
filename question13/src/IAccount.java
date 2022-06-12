import java.io.Serializable;

public interface IAccount extends Serializable{
	//function in the IAccount
	public String getName();
	public int getMoney();
	public void withdraw(int amount) throws NotEnoughMoneyException;
}
