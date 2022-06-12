
public class GUI {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Bank m = new Bank("UIC bank");
				
				//set controller
				ControllerSimple c1 = new ControllerSimple(m);
				
				ControllerGetMoney c2 = new ControllerGetMoney(m);
				
				ControllerWithdraw c3 = new ControllerWithdraw(m);
				
				ControllerCreate c4 = new ControllerCreate(m);
				
				ControllerHistory c5 = new ControllerHistory(m);
				
				ViewSimple v1 = new ViewSimple(m,c1);
				ViewGetMoney v2 = new ViewGetMoney(m,c2);
				ViewWithdraw v3 = new ViewWithdraw(m,c3);
				ViewCreate v4 = new ViewCreate(m,c4);
				ViewHistory v5 = new ViewHistory(m,c5); 
			}
		}
				);
	}
}
