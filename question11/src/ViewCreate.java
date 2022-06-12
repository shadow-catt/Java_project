import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewCreate extends View<ControllerCreate>{
	//variable
	private JTextField t1;
	private JTextField t2;
	private JComboBox<String> cb;
	
	public ViewCreate(Bank m, ControllerCreate c) {
		super(m, c);
		//initial setting
		this.setTitle("View create");
		this.setSize(250, 300);
		this.setLocation(700, 300);
		
		//set grid layout
		this.setLayout(new GridLayout(4,1));
		
		//add a text field
		t1=new JTextField("Type a customer name here");
		this.add(t1);
		//add a text field
		t2=new JTextField("Type an amount of money here");
		this.add(t2);
		
		//add a JComboBox
		cb=new JComboBox<String>(new String[]{"credit account","student account"});
		this.add(cb);
		
		//add a button
		JButton b1=new JButton("Withdraw");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c.create(t1.getText(),t2.getText(),cb.getSelectedIndex())!=""){
					JOptionPane.showMessageDialog(null,c.create(t1.getText(),t2.getText(),cb.getSelectedIndex()));
				}
			}
		});
				this.add(b1);
		
		//set visible
		this.setVisible(true);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//do nothing
	}
	
	
}
