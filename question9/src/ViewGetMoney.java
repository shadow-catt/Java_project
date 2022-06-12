import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewGetMoney extends View<ControllerGetMoney>{
	//variable
	private JTextField t;
	
	public ViewGetMoney(Bank m, ControllerGetMoney c) {
		super(m, c);
		this.setSize(250, 150);
		this.setLocation(300, 300);
		
		//set grid layout
		this.setLayout(new GridLayout(2,1));
		
		//add a text field
		t=new JTextField("Type a customer name here");
		this.add(t);
		//add a button
		JButton b1=new JButton("Tell me the money");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,c.getMoney(t.getText()));
			}
		});
		this.add(b1);
		this.setVisible(true);
	}

	public void update() {
		//nothing to do
	}
}
