package testoop.src.program_test;

/**
 * ��������1000��0-10�I�����C�󋁘a
 * @author wangz
 *
 */


public class testRandom {
	public static void main(String[] args){
		//ArrayList list = new ArrayList();
		//Random ran = new Random();
		
		int num[] = new int[1000];
		int sum = 0;
		double average;
		for(int i=0;i< num.length;i++){
			//list.add((int)Math.random()*11);
			
			num[i]=(int)(Math.random() * 11);
			sum = sum + num[i];
			System.out.println(num[i]);
		}
		average = (double)sum / 1000;
		System.out.println(sum);
		System.out.println(average);
	}	
}
