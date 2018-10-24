package study163;

public class DoWhileDemo
{
	public static void main(String[] args)
	{
		//案例1:叫500次师妹,打印500次
		int count = 0;//喊的次数
		do{
			System.out.println("师妹");
			count ++;
		}
		while(count < 5);
		System.out.println("ending...........");	
		System.out.println("--------------------------------");
		
		//案例2:从1数到100,打印1-100
		int num = 1;
		do{
			System.out.println(num);
			num ++;
		}
		while(num <= 100);
		System.out.println("ending............");
		System.out.println("--------------------------------");
		
		//案例3:计算100以内正整数之和
		int number = 1;
		int result = 0;//表示前n个数之和
		do{
			result = result + number; //等价于 result += number;
			number ++;	
		}
		while(number <= 100);
		System.out.println(result);
		System.out.println("ending............");
		
	}
}