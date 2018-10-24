package study163;

public class ScoreLeveDemo
{
	public static void main(String[] args)
	{
			
		//如果今天是周一,输出周一,如果今天是周二,输出周二....
		int score = 99;
		
		if(score >= 90){
			System.out.println("优");
		}else if(score >= 80 && score < 90){
			System.out.println("良");
		}else if(score >= 70 && score < 80){
			System.out.println("中");
		}else if(score >= 60 && score <70){
			System.out.println("合格");
		}else{
			System.out.println("多多努力");
		}
		
	}
}