package flyweight.star;

import java.util.Calendar;

public class Person {
	private String name;
	private AbstractStarSign starSign;

	public Person(String name, AbstractStarSign starSign) {
		this.name = name;
		this.starSign = starSign;
	}

	public String getName() {
		return name;
	}

	public AbstractStarSign getStarSign() {
		return starSign;
	}

	public String toString() {
		return name + ", " + starSign;
	}
	
	public void setStarSign(String name, Calendar birthday, String location) {
		starSign = StarSignFactory.getStarSign(name, birthday, location);
	}
}