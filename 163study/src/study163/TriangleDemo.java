package study163;

public class TriangleDemo
{
	public static void main(String[] args)
	{
	
		/* 
			输出三角形图案
			*
			**
			***
			****
			*****
		*/
		for(int line = 1;line <= 5;line++){
			for(int i = 1;i <= line;i++){
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}                                                 