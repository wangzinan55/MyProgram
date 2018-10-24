package GraphtTestCode;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.JVM)
public class DFSTest1 {
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testRead() throws IOException {
		File tempFile = tempFolder.newFile("tempFile.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
		bw.write("my test");
		bw.close();
		String expected = "my test\n";
		DFS dfs = new DFS();
		String result = dfs.readFile(tempFile);
		assertEquals(expected, result);
	}

	// compare output and expected output file
	@Test
	public void testFindPath() throws IOException {
		File testFileName = new File("./Graph/GraphDFS.txt");
		File OutFileName = new File("./Graph/dfsout.txt");
		DFS dfs = new DFS();
		String result = dfs.readFile(testFileName);
		ArrayList<String> path = dfs.findDFS(result);
		dfs.writeFile(OutFileName, path);
	}

	@Test
	public void assertReaders() throws IOException {
		BufferedReader expected = new BufferedReader(new FileReader(
				"./Graph/expecteddfsout.txt"));
		BufferedReader actual = new BufferedReader(new FileReader(
				"./Graph/dfsout.txt"));
		String line;
		while ((line = expected.readLine()) != null) {
			assertEquals(line, actual.readLine());
		}

		assertNull("Actual had more lines then the expected.",
				actual.readLine());
		assertNull("Expected had more lines then the actual.",
				expected.readLine());
	}
	@Test
	public void testWrite() throws IOException {
		File tempFile = tempFolder.newFile("tempFile.txt");
		ArrayList<String> s = new ArrayList<String>();
		s.add("A");
		s.add("B");
		s.add("C");
		DFS dfs = new DFS();
		dfs.writeFile(tempFile, s);
		BufferedReader br = new BufferedReader(new FileReader(tempFile));
		String s1;
		boolean a = false;
		while ((s1 = br.readLine()) != null) {
			if (s1.contains("A"))
				a = true;
		}
		assertEquals(true, a);
		tempFile.delete();
	}

}
