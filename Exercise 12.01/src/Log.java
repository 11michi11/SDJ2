import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Log {
	
	private File file;
	private static Log instance;
	private Queue<LogLine> logline;
	
	private Log() {
	}
	
	private void add(LogLine logline) {
		this.logline.add(logline);
		System.out.println(logline);
	}
	
	private Queue<LogLine> getAll() {
		return logline;
	}
	

}
