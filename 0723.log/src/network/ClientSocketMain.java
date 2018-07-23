package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocketMain {

	public static void main(String[] args) {
		try {
			//서버에 접속
			//Socket socket = new Socket(ip, port);
			InetAddress addr = InetAddress.getByName("192.168.0.228");
			Socket socket = new Socket(addr, 9999);
			
			//전송할 메세지 입력받기
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("전송할 메세지 : ");
			String msg = br.readLine();
			br.close();
			
			//전송할 스트림 생성
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			//데이터 전송
			pw.println(msg);
			pw.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
