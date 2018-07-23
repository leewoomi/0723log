package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			InetAddress addr = InetAddress.getByName("www.google.co.kr");
			System.out.println(addr);
			System.out.println("=================");
			InetAddress [] ar = InetAddress.getAllByName("www.naver.com");
			for(InetAddress imsi : ar) {
				System.out.println(imsi);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
