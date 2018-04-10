import java.util.jar.Attributes.Name;

public class Student {
	
	private int studyNumber;
	private Name name;
	private Nationality nationality;
	
	public Student(int studyNumber, String firstName, String lastName, String countryCode, String country) {
		this.studyNumber = studyNumber;
		name = new Name(firstName);
		nationality = new Nationality(countryCode, country);
	}
	
	public Name getName() {
		return name;
	}
	
	public Country getNationality() {
		return nationality;
	}
	
	public int getStudyNumber() {
		return studyNumber;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
	public void setNationality(String countryCode, String country) {
		nationality = new Nationality(countryCode, country);
	}
	
	public void setStudyNumber(int studyNumber) {
		this.studyNumber = studyNumber;
	}
	
	public String toString() {
		return "Student name " + name;
	}
	
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Student))
			return false;
		
		Student other = (Student) obj;
		return this.name == other.getName() && this.nationality == other.getNationality() && this.studyNumber == other.getStudyNumber();
	}
	

}
