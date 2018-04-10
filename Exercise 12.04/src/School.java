
public class School extends Education{
	
	private String type;

	public School(String code, String title, String type) {
		super(code, title);
		this.type = type;
	}
	
	public String getSchoolType() {
		return type;
	}
	
	public String toString() {
		return "School type" + type;
	}
}
