package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MemberMain {

	public static void main(String[] args) {

		// 객체 단위로 데이터를 기록할 수 있는 클래스의 변수 선언
		ObjectOutputStream oos = null;
		try {
			// 파일에 객체 단위로 기록할 수 있는 클래스의 객체 만들기
			oos = new ObjectOutputStream(new FileOutputStream("./oos.txt"));

			Member member = new Member();
			member.setName("leewoomi");
			member.setAge(24);
			member.setId("woomi1114");
			member.setPassword("1234");
			// System.out.println(member.getAge());

			// 객체를 파일에 기록
			oos.writeObject(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}

		// 객체 단위로 데이터를 기록할 수 있는 클래스의 변수 선언
		ObjectInputStream ois = null;
		try {
			// 파일에 객체 단위로 기록할 수 있는 클래스의 객체 만들기
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));

			// read로 읽어올 때 Object 타입으로 리턴하기 때문에 강제 형 변환을 해서 원래의 자료형으로 되돌려서 사용해야 한다.
			Member member = (Member) ois.readObject();
			System.out.println(member.getName());
			System.out.println(member);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
