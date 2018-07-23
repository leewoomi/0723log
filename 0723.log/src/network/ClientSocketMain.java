package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocketMain {

	public static void main(String[] args) {
		try {
			//������ ����
			//Socket socket = new Socket(ip, port);
			InetAddress addr = InetAddress.getByName("192.168.0.228");
			Socket socket = new Socket(addr, 9999);
			
			//������ �޼��� �Է¹ޱ�
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("������ �޼��� : ");
			String msg = br.readLine();
			br.close();
			
			//������ ��Ʈ�� ����
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			//������ ����
			pw.println(msg);
			pw.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
