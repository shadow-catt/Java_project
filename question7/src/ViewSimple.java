import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewSimple extends JFrame implements ModelListener{
	//variable
	private Bank m;
	private ControllerSimple c;
	private JLabel label;
	
	public ViewSimple(Bank m,ControllerSimple c) {
		//initial value
		this.m = m;
		this.c = c;
		label = new JLabel();
		//default setting
		this.setTitle("View Simple");
		this.setSize(250, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 300);
		m.addListener(this);//add the view
		//Initialize the label using the model
		update();
		//add label for the view simple
		this.add(label);
		this.setVisible(true);
	}
	public void update() {
		label.setText("Total money: " + m.totalMoney());
	}
}
