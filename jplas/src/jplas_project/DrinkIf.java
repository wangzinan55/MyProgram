package jplas_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��151��
 * @author Wangzinan
 *
 */

public class DrinkIf {
	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("ϲ��ʲôʳ��");
			System.out.println("a=��֭");
			System.out.println("b=����");
			System.out.println("c=�ĸ�����ѡ");
			System.out.println("����a��b��c����ѡһ��:");
			String line = reader.readLine();
			if (line.equals("a") ){
				System.out.println("��֭!");
			} else if (line.equals("b")) {
				System.out.println("����!");
			} else {
				System.out.println("�ĸ�����Ҫ!");
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("���ֵ���ʽ����ȷ��");
			}
	}
}
