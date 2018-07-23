package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		// UDP 전송을 받는 곳

		try {
			// 포트번호 설정
			DatagramSocket ds = new DatagramSocket(7777);
			while (true) {
				// 데이터를 저장할 배열을 생성
				byte[] b = new byte[2312];
				// DatagramPacket 생성
				DatagramPacket dp = new DatagramPacket(b, 2312);
				// 데이터 받기
				ds.receive(dp);
				// 데이터를 읽어서 출력
				String msg = new String(b, 0, 2312);
				System.out.println("보낸 곳 : " + dp.getAddress());
				System.out.println("msg: " + msg);
				System.out.println("length : "+ dp.getLength());
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
