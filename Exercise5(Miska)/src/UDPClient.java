import java.io.*; import java.net.*;
import java.util.GregorianCalendar;
public class UDPClient {

	public static void main(String[] args) throws IOException{
		final int PORT = 2910;
		final String HOST = "localhost";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		
		InetAddress IPAddress = InetAddress.getByName(HOST);
		byte[] sendData = new byte[1024];
		byte[] recieveData = new byte[1024];
		
		Long time = GregorianCalendar.getInstance().getTimeInMillis();
		System.out.println("Write a line for the server: ");
		String message = in.readLine();
		System.out.println("Client> " + message + ", time :" + time);
		sendData = message.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
		Long time1 = GregorianCalendar.getInstance().getTimeInMillis();
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
		
		clientSocket.receive(receivePacket);
		Long time2 = GregorianCalendar.getInstance().getTimeInMillis();
		String modifiedStc = new String(receivePacket.getData()).trim();
		System.out.println("Server> " + modifiedStc + ", time :" + time);
		System.out.println("Time elapsed:" + (time2-time1) + "ms");
		
		clientSocket.close();
	}
}
