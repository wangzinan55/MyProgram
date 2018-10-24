package testoop.src.cn.bjsxt.oop;

public class Student {
	//静态数据
	private String name;
	private int age;
	private int ID;
	private int weight;
	
//	动态变量
	public void study(){
		System.out.println(name+"在学习");
	}
	
	public void sayHellow(){
		System.out.println(name+"说:你好");
	}
	
	public static void main(String[] args){
		Student s1 = new Student();
		s1.name = "sunny";
		s1.study();
		s1.sayHellow();
	}

}
