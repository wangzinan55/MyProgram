package polymoph;

/**
 * 多态的存在有三个必要条件
 * 1.要有继承
 * 2.要有重写
 * 3.父类引用指向子类对象
 * 条件满足时，当调用父类被重写的方法时，new的是哪个子类对象，就调用这个子类对象的方法
 *
 */

class Animal{
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void enjoy() {
		System.out.println("叫声。。。。。");
	}
}

class Bird extends Animal{
	public Bird() {
		super("bird");
	}
	
	public void enjoy() {
		System.out.println("鸟叫声。。。。。");
	}
}


class Cat extends Animal{
	private String eyesColor;
	
	public Cat(String n,String c) {
		super(n);
		eyesColor = c;
	}
	
	public void enjoy() {
		System.out.println("猫叫声。。。。。");
	}
}

class Dog extends Animal{
	private String furColor;
	
	public Dog(String n,String c) {
		super(n);
		furColor = c;
	}
	
	public void enjoy() {
		System.out.println("狗叫声。。。。。");
	}
}

class Lady{
	private String name;
	private Animal pet;
	
	public Lady(String name,Animal pet) {
		this.name = name ;
		this.pet = pet;
	}
	
	public void myPetEnjoy() {
		pet.enjoy();
	}
}

public class TestPolymoph {
	public static void main (String[] args) {
		Cat c = new Cat("catname", "bule");
		Dog d = new Dog("dogname", "black");
		Bird b = new Bird();
		Lady l1 = new Lady("11", c);
		Lady l2 = new Lady("12", d);
		Lady l3 = new Lady("13", b);
		l1.myPetEnjoy();
		l2.myPetEnjoy();
		l3.myPetEnjoy();
	}
}
