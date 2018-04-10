
public class Student {
	
	private String name;
	private Education education;
	
	public Student(String name, Education educationCode) {
		this.name = name;
		this.education = educationCode;
	}
	
	public String getName() {
		return name;
	}
	
	public Education getEducation() {
		return education;
	}
	
	public String toString() {
		return "Student name : " + name + "Education : " + education;
	}
	

}
