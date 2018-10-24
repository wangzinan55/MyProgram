package mypro01.src.com.helloworld;
import java.util.Scanner;


/**
 * 测试Scanner类的使用，如何接受键盘的输入
 * @author wangz
 *
 */

public class TestScanner {
	public static void test01(){
	Scanner s = new Scanner(System.in);
	String str = s.next();
	System.out.println("刚才键盘输入："+str);
	}
	
/**
 * 构造简单的加法器
 */
	public static void test02(){
		Scanner s = new Scanner(System.in);
		System.out.println("输入加数:");
		int a = s.nextInt();
		System.out.println("输入被加数:");
		int b = s.nextInt();
		int sum = a+b;
		System.out.println("两数之和"+sum);
	}
	
	
	public static void main(String[] args){
		test02();
	}
}
