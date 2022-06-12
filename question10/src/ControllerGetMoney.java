
public class ControllerGetMoney extends Controller{

	public ControllerGetMoney(Bank m) {
		super(m);
		// TODO Auto-generated constructor stub
	}
	public String getMoney(String name) {
		try {
			return ""+m.getMoney(name);
		} catch (UnknownCustomerException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
