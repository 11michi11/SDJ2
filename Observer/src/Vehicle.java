
public abstract class Vehicle {
	
	protected Semafor subject;
	protected int id;
	private static int nextId = 0;
	
	public Vehicle(Semafor subject) {
		this.subject = subject;
		id = ++nextId;
	}
	
	public abstract void update();

}
