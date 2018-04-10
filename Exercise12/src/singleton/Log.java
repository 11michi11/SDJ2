package singleton;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Log {

	private static Log instance;
	private File logFile;
	private Queue<LogLine> logs;

	private Log() {
		logFile = new File("log.txt");
		logs = new LinkedBlockingQueue<LogLine>();
	}
	
	public Log getInstance() {
		if(instance == null)
			instance = new Log();
		return instance;
	}
	
	

	private void addToFile(LogLine log) {
		if (log == null) {
			return;
		}
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(logFile, true));
			out.write(log + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
