import java.util.HashMap;

public class EducationFactory {

	static String headOfProgramme, title, code;
	
	private static HashMap<String, Education> educations = new HashMap<String, Education>();
	
	public static Education getEducation(String educationCode) {
		Education item = educations.get(educationCode);
		
		
		if(item == null) {
			item = new Programme(title, code, headOfProgramme);
			educations.put(educationCode, item);
		}
		return item;
		
		
	}

}
