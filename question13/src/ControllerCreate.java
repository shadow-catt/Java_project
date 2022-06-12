
public class ControllerCreate extends Controller{

	public ControllerCreate(Bank m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	public String create(String t1, String t2, int selectedIndex) {
		// TODO Auto-generated method stub
	switch(selectedIndex) {
//for credit account
	case(0):
		m.addAccount(new CreditAccount(t1,Integer.parseInt(t2)));
		return "";
//for student account
	case(1):
		try {
			m.addAccount(new StudentAccount(t1,Integer.parseInt(t2)));
			return "";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		} catch (NotEnoughMoneyException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
//for wrong number
	default:
		return "BUG! This must never happen!";
	}

}
}
