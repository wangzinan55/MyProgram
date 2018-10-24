package testFile03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

//BufferedReader + ����ʹ����Դ������
public class TestReadFile {
	public static void main(String args[]) {

		String fileName = "/Users/wangzinan/Documents/workspace/testFile/test.txt";

		try (BufferedReader br = new BufferedReader(
                new InputStreamReader(        //�����ФȥХ����g�Ή�Q
                        new FileInputStream(fileName),
                        StandardCharsets.UTF_8))) {

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
