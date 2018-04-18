import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Log {

	private File file;
	private static Log instance;
	private Queue<LogLine> logline;

	private Log() {
		logline = new LinkedList<LogLine>();
	}
	
	public Log getInstance() {
		if(instance == null)
			instance = new Log();
		return instance;
	}

	public void add(LogLine logline) {
		this.logline.add(logline);
		System.out.println(logline);
	}

	public Queue<LogLine> getAll() {
		return logline;
	}

}
