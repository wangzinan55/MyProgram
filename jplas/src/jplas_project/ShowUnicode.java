package jplas_project;

/**
 * ��146��
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowUnicode {
	public static void main(String[] args) {
		System.out.println("����������");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = reader.readLine();
			for(int i=0;i<line.length();i++){
				char c = line.charAt(i);
				System.out.println("+c+���֥��`�ɤ�"+(int)c+"�Ǥ�");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
