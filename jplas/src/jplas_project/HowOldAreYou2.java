package jplas_project;

/**
 * ��148��
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou2 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�����һ���˵�����:");
		try {
			String line;
			//��һ��
			String name1 = reader.readLine();
			System.out.println("������"+name1+"������:");
			line = reader.readLine();
			int age1 = Integer.parseInt(line);
			//�ڶ���
		    System.out.println("����ڶ����˵�����:");
		    String name2 = reader.readLine();
		    System.out.println("������"+name2+"������:");
		    line = reader.readLine();
		    int age2 = Integer.parseInt(line);
		    //ƽ��
		    double average = (age1 + age2) / 2.0;
		    System.out.println(name1+"��"+name2+"��ƽ��������:"+average);
		} catch (IOException e) {
			System.out.println(e);
		}catch (NumberFormatException e) {
			System.out.println("���䲻��ȷ");
		}
	}
}
