 package testoop.src.cn.bisxt.oop.polymorphism;

public class Animal {
	String str;
	public void voice(){
		System.out.println("普通动物叫声！");
	}
}

class Cat extends Animal{
	public void voice(){
		System.out.println("miaomiaomiao");
	}
	public void catchMouth(){
		System.out.println("zhualaoshu");
	}
}

class Dog extends Animal{
	public void voice(){
		System.out.println("wangwangwang");
	}
	public void seeDoor(){
		System.out.println("kanmen");
	}
}

class Pig extends Animal{
	public void voice(){
		System.out.println("henghengheng");
	}
}