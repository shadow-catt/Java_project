import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewWithdraw extends View<ControllerWithdraw>{
	//variable
	private JTextField t1;
	private JTextField t2;
	
	public ViewWithdraw(Bank m, ControllerWithdraw c) {
		super(m, c);
		//initial setting
		this.setTitle("View Withdraw");
		this.setSize(250, 200);
		this.setLocation(500, 300);
		
		//set grid layout
		this.setLayout(new GridLayout(3,1));
		
		//add a text field
		t1=new JTextField("Type a customer name here");
		this.add(t1);
		//add a text field
		t2=new JTextField("Type an amount of money here");
		this.add(t2);
		
		//add a button
		JButton b1=new JButton("Withdraw");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c.withdraw(t1.getText(),t2.getText())!=""){
					JOptionPane.showMessageDialog(null,c.withdraw(t1.getText(),t2.getText()));
				}
			}
		});
		this.add(b1);
		this.setVisible(true);
	}
	public void update() {
		//do nothing
	}
}
