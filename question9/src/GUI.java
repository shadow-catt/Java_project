
public class GUI {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Bank m = new Bank("UIC bank");
				
				ControllerSimple c1 = new ControllerSimple(m);
				
				ControllerGetMoney c2 = new ControllerGetMoney(m);
				
				try {
					StudentAccount s1 = new StudentAccount("Justin",1000);
					m.addAccount(s1);
				} catch (NotEnoughMoneyException e) {
					e.printStackTrace();
				}
				
				ViewSimple v1 = new ViewSimple(m,c1);
				ViewGetMoney v2 = new ViewGetMoney(m,c2);
			}
		}
				);
	}
}
