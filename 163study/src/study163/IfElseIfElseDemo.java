package study163;


public class IfElseIfElseDemo
{
	public static void main(String[] args)
	{
			
		//如果今天是周一,输出周一,如果今天是周二,输出周二....
		int day = 6;
		
		if(day == 1){
			System.out.println("周一");
		}else if(day == 2){
			System.out.println("周二");
		}else if(day == 3){
			System.out.println("周三");
		}else if(day == 4){
			System.out.println("周四");
		}else if(day == 5){
			System.out.println("周五");
		}else if(day == 6){
			System.out.println("周六");
		}else if(day == 7){
			System.out.println("周日");
		}else{
			System.out.println("没有这一天");
		}
		
	}
}