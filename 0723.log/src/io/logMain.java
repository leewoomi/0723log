package io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import java.util.Set;

//import  ����Ű ctrl + shift + o
public class logMain {

	public static void main(String[] args) {
		// 1.BufferedReader ��ü ����
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("C:\\�̿��\\�ڹ�_C\\�ڹ�\\access_log.txt"));

			// 4.HashMap�� �̿��ؼ� ������ IP �� Ƚ���� ���
			HashMap<String, Integer> map = new HashMap<>();
			// 5.HashMap�� �̿��ؼ� ������ IP �� Ʈ���� �հ� ���
			HashMap<String, Integer> traffic = new HashMap<>();
			// 2. �� ������ ������ �о ���
			while (true) {
				// �� �� �б�
				String line = br.readLine();
				// ���� �����Ͱ� ������ ����
				if (line == null) {
					break;
				}
				// System.out.println(line);

				// 3. �� ������ ���� �����͸� �������� �����ؼ�
				// ù��°�� �ִ� �����͸� ���
				// line�� ���� ������ ����
				String[] ar = line.split(" ");
				// System.out.println(ar[0]);

				// ip�� ����� �����͸� �����´�.
				Integer count = map.get(ar[0]);
				// ����� �����Ͱ� ������ 1�� ����
				if (count == null) {
					map.put(ar[0], 1);
				}
				// ����� �����Ͱ� ������ 1�� ���ؼ� ����
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
			// ���� ��� �����͸� ���
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
