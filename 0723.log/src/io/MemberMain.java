package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MemberMain {

	public static void main(String[] args) {

		// ��ü ������ �����͸� ����� �� �ִ� Ŭ������ ���� ����
		ObjectOutputStream oos = null;
		try {
			// ���Ͽ� ��ü ������ ����� �� �ִ� Ŭ������ ��ü �����
			oos = new ObjectOutputStream(new FileOutputStream("./oos.txt"));

			Member member = new Member();
			member.setName("leewoomi");
			member.setAge(24);
			member.setId("woomi1114");
			member.setPassword("1234");
			// System.out.println(member.getAge());

			// ��ü�� ���Ͽ� ���
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

		// ��ü ������ �����͸� ����� �� �ִ� Ŭ������ ���� ����
		ObjectInputStream ois = null;
		try {
			// ���Ͽ� ��ü ������ ����� �� �ִ� Ŭ������ ��ü �����
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));

			// read�� �о�� �� Object Ÿ������ �����ϱ� ������ ���� �� ��ȯ�� �ؼ� ������ �ڷ������� �ǵ����� ����ؾ� �Ѵ�.
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
