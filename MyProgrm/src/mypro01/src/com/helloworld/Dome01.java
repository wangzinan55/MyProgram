package mypro01.src.com.helloworld;

public class Dome01 {
	public static void main(String[] args) { 
			int a, b;
			int row = 3;
			for(a=1; a<=row; a++){
				for(b=1; b<=a-1; b++){
					System.out.print(" ");
					}
				for(b=1; b<= row+1-a; b++) {
					System.out.print("* ");
					}
				System.out.println();
				} 
			}
		}
	
