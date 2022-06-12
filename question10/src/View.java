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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add the view
		m.addListener(this);
		
	}

}
