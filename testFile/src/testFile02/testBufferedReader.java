package testFile02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//BufferedReader + Stream
public class testBufferedReader {
	 public static void main(String[] args) {
        
	        String fileName = "/Users/wangzinan/Documents/workspace/testFile/test.txt";
//			List<String> list = new ArrayList<>();

			try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {

	        	br.lines().forEach(line -> {
	 	                System.out.println(line);
	 	            });

			} catch (IOException e) {
				e.printStackTrace();
			}
	
	        
	    }
}
