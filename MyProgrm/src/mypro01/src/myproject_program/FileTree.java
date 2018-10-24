package mypro01.src.myproject_program;


/**
 * ��ӡ��״Ŀ¼
 * @author Wangzinan
 */

import java.io.File;

public class FileTree {
		public static void main(String[] arg){
			File f = new File("c:/test");
			printFile(f,0);
		}

		static void printFile(File file, int level) {
			for (int i = 0; i < level; i++) {
				System.out.print("-");
			}
			System.out.println(file.getName());
			
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File test : files) {
					printFile(test, level+1);
				}
			}
			
		}
}
