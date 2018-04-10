
public abstract class Country {
	
	private String countryCode;
	private String country;
	
	public Country(String countryCode, String country) {
		this.countryCode = countryCode;
		this.country = country;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String toString() {
		return "Country : " + country + " Country code : " + countryCode;
	}
	
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Country))
			return false;
		
		Country other = (Country)obj;
		return this.country == other.getCountry() && this.countryCode == other.getCountryCode();
		
	}
	

}
