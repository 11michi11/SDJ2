package exerciseB;

public class Task {
	
	private String text;
	private long estimatedTime;
	
	public Task(String text, long estimatedTime) {
		this.text = text;
		this.estimatedTime = estimatedTime;
	}
	
	public String getText() {
		return text;
	}
	
	public long getEstimatedTime() {
		return estimatedTime;
	}
	
	public void setEstimatedTime() {
		this.estimatedTime = estimatedTime;
	}
	
	public String toString() {
		return text + ", (Estimated time = " + estimatedTime + ")";
	}

}
