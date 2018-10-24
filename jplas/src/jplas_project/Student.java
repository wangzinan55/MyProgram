package jplas_project;

/**
 * 第168题
 * @author Wangzinan
 *
 */

public class Student {
	String name;   // ﾃ錥ﾖ
	int [] tens;         // ｿｼﾊﾔｷﾖﾊ�
	public Student (String name,int[] tens){
		this.name=name;
		this.tens=tens;
	}
	
	public Student (String name,int x,int y,int z){
		this.tens = new int[3];
		this.name=name;
		this.tens[0]=x;
		this.tens[1]=y;
		this.tens[2]=z;
	}
	
	 public String toString(){
		 String s = "[" +name;
		 for (int i = 0; i < tens.length; i++) {
			s += ","+tens[i];
		}
		 s +="]";
		 return s;		 
	 }
	 public int total(){
		 int sum = 0;
		 for (int i = 0; i < tens.length; i++) {
			sum += tens[i];
		}
		 return sum;
	 }
	
}
