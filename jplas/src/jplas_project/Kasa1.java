package jplas_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��149��
 * @author Wangzinan
 *
 */

public class Kasa1 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("���뽵ˮ��:");
			String line = reader.readLine();
			int n = Integer.parseInt(line);
			System.out.println("��ˮ����"+n+"%");
			if(n >= 50){
				System.out.println("��Ҫ���Ǵ�ɡ");
			}else {
				System.out.println("����Ҫ��ɡ");
			}
			System.out.println("лл��");
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("���ֵ���ʽ��׼ȷ");
		}
		
	}
}
