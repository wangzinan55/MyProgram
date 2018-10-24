package testoop.src.program_test;

import java.util.Random;

/**
 * Studenｔ做成一个包括复数的实例的数组,科目分数为满分100,并随机生成一个数
 * @author wangz
 *
 */

class Student{
	String name;
	int japanese;
	int mathematics;
	int english;
	int science;
	int society;
	
	public Student(String name){
		this.name=name;
	}
	
	public void show01(){
		System.out.println("name:"+this.name+"\njapanese:"+this.japanese);
	}
	
	public void show02(){
		System.out.println("name:"+this.name+"\nmathematics:"+this.mathematics);
	}
	
	public void show03(){
		System.out.println("name:"+this.name+"\nenglish:"+this.english);
	}
	
	public void show04(){
		System.out.println("name:"+this.name+"\nsciense:"+this.science);
	}
	
	
	public void show05(){
		System.out.println("name:"+this.name+"\nsociety:"+this.society);
	}
	
	public static double japansum(Student[] ss){
		double result=0;
		for(Student s:ss){
			result+=s.japanese;
		}
		return result;
	}
}

public class testStudent {
	

	
	public static void main(String[] args){
		
		Random ran = new Random();
		
		Student[] students={
				new Student("a"),
				new Student("b"),
				new Student("c"),
				new Student("d")
		};
		
		for(int i=0;i<students.length;i++){
			students[i].japanese= ran.nextInt(101);
			students[i].mathematics= ran.nextInt(101);
			students[i].english= ran.nextInt(101);
			students[i].science= ran.nextInt(101);
			students[i].society= ran.nextInt(101);
			students[i].show03(); //英語の得点
			
		}
		System.out.println("************");
		
		System.out.println(Student.japansum(students));
		
		
	//	double japanseavg=(students[0].japanese+students[1].japanese+students[2].japanese+students[3].japanese)/4.0;
	//	System.out.println( "japanseavg:" +japanseavg);
		
	//	double mathematicsavg=(students[0].mathematics+students[1].mathematics+students[2].mathematics+students[3].mathematics)/4.0;
	//	System.out.println( "mathematicsavg:" +mathematicsavg);
		
	//	double englishavg=(students[0].english+students[1].english+students[2].english+students[3].english)/4.0;
	//	System.out.println( "englishavg:" +englishavg);//英語の平均数
}
}
