package flyweight.nationality;

public class Student {

	private int studentNumner;
	private String name;
	private Country country;

	public Student(int studentNumner, String name, String countryCode, String country) {
		this.studentNumner = studentNumner;
		this.name = name;
		this.country = CountryFactory.getNationality(countryCode, country);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentNumner() {
		return studentNumner;
	}

	public void setStudentNumner(int studentNumner) {
		this.studentNumner = studentNumner;
	}

	public Country getNationonality() {
		return country;
	}

	public void setNationality(String countryCode, String country) {
		this.country = CountryFactory.getNationality(countryCode, country);
	}

}
