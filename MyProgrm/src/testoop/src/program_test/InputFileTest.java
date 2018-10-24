package testoop.src.program_test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputFileTest {
		
	public static void main(String[] args) {
		try {
			int value = 0;
			int sum = 0;
			int count = 0;
			String num = "";
			
			Scanner scan = new Scanner(new File("C:/C�H��/eclipse/workspace/data.csv"));
			while(scan.hasNext()){
				String str = scan.next();
				System.out.println(str);
				num = str;
				count++;
			
			for(int i=0;i<=count;i++){
				value=Integer.parseInt(num);				
			}
			sum += value;
		}
			scan.close();
			System.out.println("********");
			System.out.println(sum);
			System.out.println(count);
			System.out.println(sum/count);
			

			File file = new File("output.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.print(sum);
			pw.close();
		} catch (Exception e) {
			throw new RuntimeException(e.toString());
		}
	}
	
}
