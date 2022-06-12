import javax.swing.JLabel;

public class ViewSimple extends View<Controller>{
	//variable
	private JLabel label;
	
	public ViewSimple(Bank m,ControllerSimple c) {
		//initial value
		super(m,c);
		label = new JLabel("Total money: " + m.totalMoney());
		//default setting
		this.setTitle("View Simple");
		this.setSize(250, 150);
		this.setLocation(100, 300);
		//add label for the view simple
		this.add(label);
		this.setVisible(true);
	}
	public void update() {
		label.setText("Total money: " + m.totalMoney());
	}
}
