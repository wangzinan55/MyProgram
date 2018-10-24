package jplas_project;

/**
 * 第148题
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou2 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("输入第一个人的名字:");
		try {
			String line;
			//第一人
			String name1 = reader.readLine();
			System.out.println("请输入"+name1+"的年龄:");
			line = reader.readLine();
			int age1 = Integer.parseInt(line);
			//第二人
		    System.out.println("输入第二个人的名字:");
		    String name2 = reader.readLine();
		    System.out.println("请输入"+name2+"的年龄:");
		    line = reader.readLine();
		    int age2 = Integer.parseInt(line);
		    //平均
		    double average = (age1 + age2) / 2.0;
		    System.out.println(name1+"和"+name2+"的平均年龄是:"+average);
		} catch (IOException e) {
			System.out.println(e);
		}catch (NumberFormatException e) {
			System.out.println("年龄不正确");
		}
	}
}
