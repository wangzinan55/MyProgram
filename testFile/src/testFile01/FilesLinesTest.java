package testFile01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
                

//Files.lines读取文件的流

public class FilesLinesTest {

    public static void main(String[] args) {

    	String fileName = "/Users/wangzinan/Documents/workspace/testFile/test.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {

			//stream.forEach(System.out::println); 
			stream.forEach(line -> { 
                System.out.println(line);
            });

		} catch (IOException e) {
			e.printStackTrace();
		}      
    }
}