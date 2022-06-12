
public class ControllerWithdraw extends Controller {

	public ControllerWithdraw(Bank m) {
		// TODO Auto-generated constructor stub
		super(m);
	}

	public String withdraw(String text, String text2) {
		// TODO Auto-generated method stub
		try {
			m.withdraw(text, Integer.parseInt(text2));
			return "";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		} catch (UnknownCustomerException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		} catch (NotEnoughMoneyException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	

}
