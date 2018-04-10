import java.util.Calendar;
import java.util.HashMap;

public class StarSignFactory {
	
	private static HashMap<String, StarSign> signs = new HashMap<String, StarSign>();
	
	public static StarSign getStarSing(String name) {
		StarSign item = signs.get(name);
		
		if(item == null) {
			item = new StarSign(name);
			signs.put(name, item);
		}
		return item;
	}
		
	
	public static AbstractStarSign getStarSign(String name, Calendar birthday, String location) {
		return new StarSignWithInterpretation(name, birthday, location);
	}

}
