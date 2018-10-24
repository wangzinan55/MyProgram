package jplas_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第149题
 * @author Wangzinan
 *
 */

public class Kasa1 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("输入降水率:");
			String line = reader.readLine();
			int n = Integer.parseInt(line);
			System.out.println("降水率是"+n+"%");
			if(n >= 50){
				System.out.println("不要忘记带伞");
			}else {
				System.out.println("不需要带伞");
			}
			System.out.println("谢谢！");
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("数字的形式不准确");
		}
		
	}
}
