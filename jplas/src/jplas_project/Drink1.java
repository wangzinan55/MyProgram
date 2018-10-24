package jplas_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第152题
 * @author Wangzinan
 *
 */


public class Drink1 {
	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("喜欢什么食物：");
			System.out.println("1 橙汁");
			System.out.println("2 咖啡");
			System.out.println("3 哪个都不选");
			System.out.println("请在1，2，3，中选一个:");
			String line = reader.readLine();
			int n = Integer.parseInt(line);
			switch (n) {
			case 1:
				System.out.println("橙汁");
				break;
			case 2:
				System.out.println("咖啡");
				break;			
			default:
				System.out.println("哪个都不选！");
				break;
			}
		} catch (IOException e) {
			System.out.println(e);
		}catch (NumberFormatException e) {
			System.out.println("数字的形式不正确！");
			}

	}
}
