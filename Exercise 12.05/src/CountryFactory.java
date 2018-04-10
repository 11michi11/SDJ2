import java.util.HashMap;

public class CountryFactory {
	
	private static HashMap<String, Country> countries = new HashMap<String, Country>();
	
	private static Country getNationality(String countryCode, String country) {
		Country item = countries.get(country);
		
		if(item == null) {
			item = new Nationality(countryCode, country);
			countries.put(countryCode, item);
		}
		return item;
	}

}
