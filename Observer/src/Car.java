public class Car extends Vehicle {
	
	
	
	public Car(Semafor semafor) {
		super(semafor);
	}

	@Override
	public void update() {
		if(subject.getState().equals(Semafor.GREEN))
			System.out.println("Car " + id + ": GO!");
		else
		System.out.println("Car " + id + ": wait...");
	}

}
