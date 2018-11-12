package study163;

class Person1{
	private String name;
	private String location;
	
	Person1(String name){
		this.name = name;
		location = "beijing";
	}
	
	Person1(String name,String location){
		this.name = name;   
		this.location = location;
	}
	
	public String info() {
		return "name:" + name + "location:" + location;
	}
}

class Teacher extends Person1{
	private String capital;
	
	Teacher(String name,String capital){
		this(name,"beijing", capital);
	}
	
	public Teacher(String n,String l,String capital) {
		super(n,l);
		this.capital = capital;
	}
	
	public String info() {
		return super.info() + "capital" + capital;
	}
}


public class TestTeacher {
	public static void main(String[] args) {
		Teacher t1 =  new Teacher("D", "professor");
		System.out.println(t1.info());
	} 
}
