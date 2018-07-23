package io;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterMain {

	public static void main(String[] args) {
		// 파일, 네트워크, 데이터베이스 관련 클래스들은 예외 처리를 강제합니다.

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
