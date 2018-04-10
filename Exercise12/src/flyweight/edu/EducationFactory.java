package flyweight.edu;

import java.util.HashMap;
import java.util.Map;

public class EducationFactory {

	private static Map<String, Education> educations = new HashMap<String, Education>();

	public static Education getEducation(String educationCode) {
		Education item = educations.get(educationCode);
		if (item == null) {
			if (educationCode.equals("ICT"))
				item = new Programme(educationCode, "ICT Engineering", "SEK");
			else if (educationCode.equals("HJS"))
				item = new Programme(educationCode, "Horsens Junior School", "Elementary School");
			educations.put(educationCode, item);
		}
		return item;
	}

}
