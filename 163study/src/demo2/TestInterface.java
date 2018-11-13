package demo2;

import java.nio.file.StandardWatchEventKinds;

/**
 * 
 *
 */

interface Singer{
	public void sing();
	public void sleep();
}

interface Painter{
	public void paint();
	public void eat();
}

class Student implements Singer{
	private String name;
	
	Student(String name){
		this.name = name;
	}
	
	public void Study() {
		System.out.println("Student is studying");
	}
	
	public String getNmae() {
		return name;
	}
	
	public void sing() {
		System.out.println("Student is studying");
	}
	
	public void sleep() {
		System.out.println("Student is studying");
	}
	
}

class Teacher implements Singer,Painter{
	private String name;
	
	public String getString() {
		return name;
	}
	
	Teacher(String name){
		this.name = name;
	}
	
	public void teach() {
		System.out.println("teaching");
	}
	
	public void sing() {
		System.out.println("singing");
	}
	
	public void sleep() {
		System.out.println("sleeping");
	}
	
	public void paint() {
		System.out.println("painting");
	}
	
	public void eat() {
		System.out.println("eating");
	}
	
	
}
	

public class TestInterface {
	public static void main(String[] args) {
		Singer s1 = new Student("lee");
		s1.sing();
		s1.sleep();
		
		Singer t1 = new Teacher("steven");
		t1.sing();
		t1.sleep();
		
		Painter t2 = (Painter)t1;
		t2.paint();
		t2.eat();
		
	}
}
