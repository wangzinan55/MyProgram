package demo3;

interface Valuable {
	public double getMoney();
}

interface Protectable{
	public void beProtected();
}

interface A extends Protectable{
	public void m();
}

abstract class Animal{
	private String name;
	
	public abstract void enjoy();
}

class GoldenMonkey extends Animal implements Valuable,Protectable{
	public double getMoney() {
		return 10000;
	}
	
	public void beProtected() {
		System.out.println("live in room");
	}
	
	public void enjoy() {}
	
	
	public void test() {
		Valuable v = new GoldenMonkey();
		v.getMoney();
		Protectable p = (Protectable)v;
		p.beProtected();
	}
	
}

class Hen implements A{
	public void m() {}
	public void beProtected() {}
}


public class TestValuable {
	
}
