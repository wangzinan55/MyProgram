package testoop.src.program_test;



public class Student5 extends Student{
		int science;
		int society; 
		

	public Student5(String name,int japanese,int mathematics,int english,int science,int society) {
		super(name);
					
		this.science=science;
		this.japanese=japanese;
		this.english=english;
		this.mathematics=mathematics;
		this.society=society;
		
	}
	
	public double average(){
		
		double result=(japanese+mathematics+english+science+society)/5.0;
		System.out.println(result);
		return result;
	}
	
	public void show(){
		System.out.println("name:"+this.name+"\nscience:"+this.science);
	}
	
	public static void main(String[] args){
		
		Student5 s = new Student5("a",50,90,63,0,88);
		Student5 s1 = new Student5("b",64,80,73,99,88);
		Student5 s2 = new Student5("c",43,87,43,90,98);
		Student5 s3 = new Student5("d",66,77,58,92,84);
		s.show();
		s.average();
		
		Student5[] ss={s,s1,s2,s3};
		System.out.println(Student.japansum(ss));
		}
}
