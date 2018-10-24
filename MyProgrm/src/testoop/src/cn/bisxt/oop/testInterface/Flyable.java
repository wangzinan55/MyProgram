package testoop.src.cn.bisxt.oop.testInterface;

public interface Flyable {
	int MAX_SPEED = 11000;
	int MIN_HEIGHT = 1;
	void fly();
}

interface Attack{
	void attack();
}


class Plane implements Flyable{

	@Override
	public void fly() {
		System.out.println("飞机依靠发动机在飞");
	}	
}

class Man implements Flyable,Attack{   //一个类可实现多个接口 

	@Override
	public void fly() {
		System.out.println("被扔出去");
		
	}

    @Override
    public void attack() {
    	System.out.println("石头进行攻击");
    }
	
}
