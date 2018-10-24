package mypro01.src.myproject_program;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testReadFile {
		public static void main(String[] args) {
			FileReader reader = null;
			try {
				reader = new FileReader("c:/a.txt");
				char c = (char)reader.read();
				char c2 = (char)reader.read();
				System.out.println(""+c+c2);  
			}catch (FileNotFoundException e) { //��ֹ�ļ�������
				e.printStackTrace();
			}catch (IOException e2) { //Խ���ϲ��࣬Խ���ں��棬��Ȼ�ᱨ��
				e2.printStackTrace();
			}finally{
				try {
					if (reader!=null) {
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}                 // ��ע:1.ִ��try��catch��������ֵ��ֵ����û���������أ�
		                  //     2.ִ��finally����Ҫ��finally��ʹ��return��
		                  //     3.return
}
