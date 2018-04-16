package client.domain.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;

import com.google.gson.Gson;

public class ConnectionReceiver extends Observable implements Runnable {

	private BufferedReader in;
	private ConnectionManager manager;
	private Socket socket;

	public ConnectionReceiver(ConnectionManager manager, Socket socket) throws IOException {
		this.socket = socket;
		this.manager = manager;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		Gson gson = new Gson();
		String json;
		while (true) {
			try {
				json = in.readLine();
				handleMessage(gson.fromJson(json, Package.class));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleMessage(Package msg) {
		if (msg.getText().equals(Package.BROADCAST)) {
			setChanged();
			notifyObservers(msg);
		}else {
			manager.receiveResponse(msg);
			notifyAll();
		}
	}

}
