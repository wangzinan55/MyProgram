package jplas_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第160题
 * @author Wangzinan
 *
 */

public class ContinueTest {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.endsWith("{") && !line.endsWith("}")) {
					continue;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
