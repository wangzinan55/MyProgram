package GraphtTestCode;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.JVM)
public class BFSTest1 {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testRead() throws IOException {
		File tempFile = tempFolder.newFile("tempFile.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
		bw.write("my test");
		bw.close();
		String expected = "my test\n";
		BFS bfs = new BFS();
		String result = bfs.readFile(tempFile);
		assertEquals(expected, result);
	}

	// compare output and expected output file
	@Test
	public void testFindPath() throws IOException {
		BFS bfs = new BFS();
		File testFileName = new File("./Graph/graphBFS.txt");
		File OutFileName = new File("./Graph/bfsout.txt");
		String result = bfs.readFile(testFileName);
		String[] path = bfs.findBFS(result);
		bfs.writeFile(OutFileName, path);
	}

	@Test
	public void assertReaders() throws IOException {
		BufferedReader expected = new BufferedReader(new FileReader(
				"./Graph/expectedbfsout.txt"));
		BufferedReader actual = new BufferedReader(new FileReader(
				"./Graph/bfsout.txt"));
		String line;
		while ((line = expected.readLine()) != null) {
			assertEquals(line, actual.readLine());
		}
		assertNull("Actual had more lines than the expected.",
				actual.readLine());
		assertNull("Expected had more lines than the actual.",
				expected.readLine());
	}

	@Test
	public void testWrite() throws IOException {
		File tempFile = tempFolder.newFile("tempFile.txt");
		String[] s = new String[] { "a", "b", "c" };
		BFS bfs = new BFS();
		bfs.writeFile(tempFile, s);
		BufferedReader br = new BufferedReader(new FileReader(tempFile));
		String s1;
		boolean a = false;
		while ((s1 = br.readLine()) != null) {
			if (s1.contains("b"))
				a = true;
		}
		assertEquals(true, a);
		tempFile.delete();
	}
}
