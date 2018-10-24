package jplas_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第151题
 * @author Wangzinan
 *
 */

public class DrinkIf {
	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("喜欢什么食物");
			System.out.println("a=桔汁");
			System.out.println("b=咖啡");
			System.out.println("c=哪个都不选");
			System.out.println("请在a，b，c，中选一个:");
			String line = reader.readLine();
			if (line.equals("a") ){
				System.out.println("橙汁!");
			} else if (line.equals("b")) {
				System.out.println("咖啡!");
			} else {
				System.out.println("哪个都不要!");
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("数字的形式不正确！");
			}
	}
}
