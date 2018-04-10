package flyweight.edu;

public class Programme extends Education{

	public String headOfProgramme;

	public Programme(String code, String title, String headOfProgramme) {
		super(code, title);
		this.headOfProgramme = headOfProgramme;
	}

	public String getHeadOfProgramme() {
		return headOfProgramme;
	}
		
	public String toString() {
		return super.toString() + " " + headOfProgramme;
	}
	
}
