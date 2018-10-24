package testoop.src.cn.bjsxt.oop.abstractClass;

public abstract class Animal {
	String str;   //抽象类中也可以有普通属性
	public abstract void run();  //抽象方法的意义：把设计和方法的实现分离了
	
	public void breath(){   //抽象类中特可以有普通类
		System.out.println("呼吸");
		run(); //也可以直接调子类中的run方法
	}
}


class Cat extends Animal{

	@Override
	public void run() {
		System.out.println("猫步");		
	}	
}

class Dog extends Animal{

	@Override
	public void run() {
		System.out.println("狂奔");		
	}	

}




