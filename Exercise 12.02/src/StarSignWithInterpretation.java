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
		return "It just star";
	}
	public String toString() {
		return "Star Interpretation : " + getInterpretation();
	}

}
