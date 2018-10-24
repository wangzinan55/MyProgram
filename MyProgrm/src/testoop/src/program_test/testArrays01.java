package testoop.src.program_test;

import java.util.Scanner;
import java.util.Arrays;

public class testArrays01 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num[] = new int[5];
		System.out.println("请输入5个整数:");
		for(int i=0;i<num.length;i++){
			num[i]=sc.nextInt();
		}
		Arrays.sort(num);
		System.out.println("输出升序后的数组：");
		System.out.println(Arrays.toString(num));
	}
}
