
public class Controller {
	protected Bank m;
	public Controller(Bank m) {
		this.m=m;
	}
	protected void shutdown(){
		//call save data function
		m.saveData();
		System.exit(0);
	}
}
