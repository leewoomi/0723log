package io;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterMain {

	public static void main(String[] args) {
		// ����, ��Ʈ��ũ, �����ͺ��̽� ���� Ŭ�������� ���� ó���� �����մϴ�.

		PrintWriter pw = null;
		try {

			pw = new PrintWriter(new FileWriter("./file.txt"));
			pw.println("12 * 3  = "+12*3);
			pw.print("hello");
			pw.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

}
