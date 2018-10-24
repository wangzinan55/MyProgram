package study163;
//嵌套循环

/*
	循环解决的是某一个操作的重复执行
	如果一个重复的操作需要做N次,此时得使用嵌套循环,可以把内藏循环看成是一个整体
	<<恐怖游轮>>
*/

public class LoopInLoopDemo{
	public static void main(String[] args)	{
		//案例:师徒四人各喊100次
		for(int count = 1;count <= 4;count++)
		{
			for(int i = 1;i <= 100;i++){
				System.out.println("i=" + i);
			}
		}
					
	}
}


		//代码优化
		/* 
			嵌套循环的性能优化:
				1.循环次数少的放在外面,循环次数多的放在里层,这样可以最大程度地减少相关循环变量的实例化次数\初始化次数等.
				2.在1的基础上,将循环变量的实例化放在循环外,这样可以进一步减少实例化次数
		*/
	

/*
		//优化前
		for(int i = 0;i < 1000; i++){
			for(int j = 0;j < 100;j++){
				for(int k = 0;k < 10;k++){
					testFunction(i,j,k);
				}
			}
		}
		

		//优化后
		int i,j,k;
		for(i = 0;i < 10; i++){
			for(j = 0;j < 100;j++){
				for(k = 0;k < 1000;k++){
					testFunction(k,j,i);
				}
			}
		}
*/		