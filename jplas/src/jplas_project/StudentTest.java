package jplas_project;


/**
 * 第169题
 * @author wangz
 *
 */
public class StudentTest {
	public static void main(String[] args) {
		Student[] data = {
				new Student("A", 65,90,100),
				new Student("B", 82,73,64),
				new Student("C", 74,31,42),
				new Student("D", 100,95,99),
		};
		for (int i = 0; i < data.length; i++) {
			System.out.println("" + data[i] + "->" + data[i].total());
		}
	}
}