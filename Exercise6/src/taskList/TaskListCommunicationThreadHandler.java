package taskList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TaskListCommunicationThreadHandler implements Runnable {

	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;
	private TaskList taskList;
	
	public TaskListCommunicationThreadHandler(Socket socket, TaskList taskList) {
		this.socket = socket;
		this.taskList = taskList;
	}

	@Override
	public void run() {
		try{
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			
			
		}catch(IOException e) {
			System.out.println("Connection error");
			e.printStackTrace();
		}finally {
			System.out.println("Closing...");
			out.close();
			try {
				in.close();
				socket.close();
			} catch (IOException e) {
				System.out.println("Closing error");
				e.printStackTrace();
			}
		}
	}

	
	
	
}
