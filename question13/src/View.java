import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public abstract class View<T extends Controller> extends JFrame implements ModelListener{
	protected Bank m;
	protected T c;
	@Override
	//abstract
	public abstract void update();
	
	public View(Bank m,T c) {
		//initial operation
		this.m=m;
		this.c=c;
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//add the view
		m.addListener(this);
		//widow listener
		this.addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//shut down by controller function
				c.shutdown();
			}
		});

	}

}
