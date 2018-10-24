package jplas_project;

/**
 * 第146题
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowUnicode {
	public static void main(String[] args) {
		System.out.println("输入文字列");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = reader.readLine();
			for(int i=0;i<line.length();i++){
				char c = line.charAt(i);
				System.out.println("+c+文字コードは"+(int)c+"です");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
