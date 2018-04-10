import java.util.ArrayList;

public class Semafor {

	public final static String RED = "RED";
	public final static String YELLOW = "YELLOW";
	public final static String GREEN = "GREEN";
	
	private ArrayList<Vehicle> list = new ArrayList<>();
	private String state = RED;
	
	public void attach(Vehicle car) {
		list.add(car);
	}
	
	public void setState(String state) {
		this.state = state;
		execute();
	}

	public String getState() {
		return state;
	}

	private void execute() {
		System.out.println(state);
		for (Vehicle e : list)
			e.update();
	}
}
