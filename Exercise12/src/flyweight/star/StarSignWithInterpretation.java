package flyweight.star;

import java.util.Calendar;

public class StarSignWithInterpretation extends AbstractStarSign{

	private String location;
	private Calendar birthday;
	
	public StarSignWithInterpretation(String name, Calendar birthday, String location) {
		super(name);
		this.birthday = birthday;
		this.location = location;
	}	
	
	public String getInterpretation() {
		return "YOU ARE DUMB! STOP BELIEVING THIS BULLSHIT!";
	}
	
	public String toString() {
		return getInterpretation();
	}
	
}
