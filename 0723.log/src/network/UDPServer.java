package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		// UDP ������ �޴� ��

		try {
			// ��Ʈ��ȣ ����
			DatagramSocket ds = new DatagramSocket(7777);
			while (true) {
				// �����͸� ������ �迭�� ����
				byte[] b = new byte[2312];
				// DatagramPacket ����
				DatagramPacket dp = new DatagramPacket(b, 2312);
				// ������ �ޱ�
				ds.receive(dp);
				// �����͸� �о ���
				String msg = new String(b, 0, 2312);
				System.out.println("���� �� : " + dp.getAddress());
				System.out.println("msg: " + msg);
				System.out.println("length : "+ dp.getLength());
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
