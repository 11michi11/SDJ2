package flyweight.nationality;

import java.util.HashMap;
import java.util.Map;

public class CountryFactory {

	private static Map<String, Country> countries = new HashMap<String, Country>();
	
	public static Country getNationality(String countryCode, String country) {
		Country item = countries.get(countryCode);
		if(item == null) {
			item = new Nationality(countryCode,country);
			countries.put(countryCode, item);
		}
		return item;
	}
	
}
