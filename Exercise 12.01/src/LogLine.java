
public class LogLine {
	
	private String text;
	private DateTime dateTime;
	
	public LogLine(String text) {
		this.text = text;
	}
	
	public String getLogText() {
		return text;
	}
	
	public DateTime getDateTime() {
		return dateTime;
	}
	
	public String getTimestamp() {
		return dateTime.getTimestamp();
	}
	

}
