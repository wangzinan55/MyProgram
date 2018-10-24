package testoop.src.program_test;

import java.util.Scanner;

public class testArr {
	public static void main(String[] args){		
		Scanner s = new Scanner(System.in);
		
		System.out.println("����n����͂���:");
		int n = s.nextInt();
		
		String arr[] = new String[n];
		System.out.println("��������o�͂���:");
		
		for(int i=0; i<n;i++){
			arr[i]=s.next();
			}
		
		System.out.println("������̋t���ŏo�͂���:");
		for(int i=arr.length-1;i>=0;i--){
		System.out.println(arr[i]);
		}
	}
}
	
	
	

