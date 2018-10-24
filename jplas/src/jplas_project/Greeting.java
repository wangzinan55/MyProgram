package jplas_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第150题
 * @author Wangzinan
 *
 */


public class Greeting {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("输入现在的时间（只精确到小时）:");
			String line = reader.readLine();
			int n = Integer.parseInt(line);
			if(0 <= n && n <= 11){
				System.out.println("早上好！");
			} else if(n == 12){
				System.out.println("正午！");
			} else if (13 <= n && n <= 18) {
				System.out.println("下午好！");
			} else if (19 <= n && n <= 24) {
				System.out.println("晚上好！");
			} else {
				System.out.println("不在时间范围内！");
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("数字的形式不正确！");
		}
	}
}
