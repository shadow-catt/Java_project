
public class ViewHistory extends View<ControllerHistory>{

	public ViewHistory(Bank m, ControllerHistory c) {
		super(m, c);
		// TODO Auto-generated constructor stub
		//initial setting
		this.setTitle("View History");
		this.setSize(400, 300);
		this.setLocation(900, 300);
		
		this.add(new HistoryPanel(m));
		this.setVisible(true);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		repaint();
	}
}
