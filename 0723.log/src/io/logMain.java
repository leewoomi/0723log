package io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import java.util.Set;

//import  단축키 ctrl + shift + o
public class logMain {

	public static void main(String[] args) {
		// 1.BufferedReader 객체 생성
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("C:\\이우미\\자바_C\\자바\\access_log.txt"));

			// 4.HashMap을 이용해서 접속한 IP 별 횟수를 출력
			HashMap<String, Integer> map = new HashMap<>();
			// 5.HashMap을 이용해서 접속할 IP 별 트래픽 합계 출력
			HashMap<String, Integer> traffic = new HashMap<>();
			// 2. 줄 단위로 데이터 읽어서 출력
			while (true) {
				// 한 줄 읽기
				String line = br.readLine();
				// 읽은 데이터가 없으면 종료
				if (line == null) {
					break;
				}
				// System.out.println(line);

				// 3. 줄 단위로 읽은 데이터를 공백으로 분할해서
				// 첫번째에 있는 데이터만 출력
				// line을 공백 단위로 분할
				String[] ar = line.split(" ");
				// System.out.println(ar[0]);

				// ip로 저장된 데이터를 가져온다.
				Integer count = map.get(ar[0]);
				// 저장된 데이터가 없으면 1을 저장
				if (count == null) {
					map.put(ar[0], 1);
				}
				// 저장된 데이터가 있으면 1을 더해서 저장
				else {
					map.put(ar[0], count + 1);
				}

				Integer traf = traffic.get(ar[0]);
				if (traf == null) {
					if (!ar[9].equals("-") && !ar[9].equals("\"-\"")) {
						traffic.put(ar[0], Integer.parseInt(ar[9]));
					}
				} else {
					if (!ar[9].equals("-") && !ar[9].equals("\"-\"")) {
						traffic.put(ar[0], traf + Integer.parseInt(ar[9]));
					}
				}

			}
			// 맵의 모든 데이터를 출력
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				System.out.println(key + ":" + map.get(key));
			}
			System.out.println("===========");
			keySet = traffic.keySet();
			for (String key : keySet) {
				System.out.println(key + ":" + traffic.get(key));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
