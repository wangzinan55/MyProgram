package study163;

//静态变量static

//局部变量永远在栈stack里，分配内存永远在堆heap里，静态的东西永远在数据区data segment里，剩下的代码就在代码区。


public class Cat {
	private static int sid = 0;
	private String name;
	int id;
	
	Cat(String name){
		this.name = name;
		id = sid++;
	}
	
	public void info(){
		System.out.println("my name is " + name + "No." + id);
	}
	
	public static void main(String[] args) {
		Cat.sid = 100;
		Cat mimi = new Cat("mimi");
		Cat pipi = new Cat("pipi");
		mimi.info();
		pipi.info();
	}

}
