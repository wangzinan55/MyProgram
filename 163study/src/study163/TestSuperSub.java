package study163;

class SuperClass{
	private int n;
	
	SuperClass(){
		System.out.println("SuperClass()");
	}
	
	SuperClass(int n){
		this.n= n;
		System.out.println("SuperClass(" + n + ")");
	}
}

class SubClass extends SuperClass{
	private int n;
	
	SubClass(int n){
		//superClass()
		//若子类构造方法没有显示的调用父类的构造方法，则系统默认调用父类参数为空的构造方法
		System.out.println("SubClass(" + n + ")");
		this.n = n;
	}
	
	SubClass(){
		//子类的构造过程必须调用父类的构造方法
		//子类可以在自己的构造方法中使用super(参数列表)调用父类的构造方法
		//对super的调用必须是构造函数的第一语句。另外，使用this（参数列表）表示调用本类另外的构造方法
		super(300);  
		System.out.println("SubClass()");
	}
}


public class TestSuperSub {
	public static void main (String[] args) {
		SubClass sc1 = new SubClass();
		SubClass sc2 = new SubClass(400);
	}
}
