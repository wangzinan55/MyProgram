package study163;

public class WhileDemo
{
	public static void main(String[] args)
	{
		//案例1:叫500次师妹,打印500次
		int count = 1;//喊的次数
		while(count <= 500){
			System.out.println("师妹"+count);
			count ++;
		}
		System.out.println("ending...........");	
		System.out.println("--------------------------------");
		
		//案例2:从1数到100,打印1-100
		int num = 1;
		while(num <= 100){
			System.out.println(num);
			num ++;
		}
		System.out.println("ending............");
		System.out.println("--------------------------------");
		
		//案例3:计算100以内正整数之和
		int number = 1;
		int result = 0;//表示前n个数之和
		while(number <= 100){
			result = result + number;
			number ++;			
		}
		System.out.println(result);
		System.out.println("ending............");
	}
}