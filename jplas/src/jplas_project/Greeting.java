package jplas_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��150��
 * @author Wangzinan
 *
 */


public class Greeting {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("�������ڵ�ʱ�䣨ֻ��ȷ��Сʱ��:");
			String line = reader.readLine();
			int n = Integer.parseInt(line);
			if(0 <= n && n <= 11){
				System.out.println("���Ϻã�");
			} else if(n == 12){
				System.out.println("���磡");
			} else if (13 <= n && n <= 18) {
				System.out.println("����ã�");
			} else if (19 <= n && n <= 24) {
				System.out.println("���Ϻã�");
			} else {
				System.out.println("����ʱ�䷶Χ�ڣ�");
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("���ֵ���ʽ����ȷ��");
		}
	}
}
