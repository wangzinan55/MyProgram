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
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.JVM)
public class TSPTest1 {
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testRead() throws IOException {
		File tempFile = tempFolder.newFile("tempFile.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
		bw.write("my test");
		bw.close();
		String expected = "my test\n";
		TSP tsp = new TSP();
		String result = tsp.readFile(tempFile);
		assertEquals(expected, result);
	}

	@Test
	public void testWrite() throws IOException {
		File tempFile = tempFolder.newFile("tempFile.txt");
		ArrayList<String> s = new ArrayList<String>();
		s.add("A");
		s.add("B");
		s.add("C");
		TSP tsp = new TSP();
		tsp.writeFile(tempFile, s);
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

	@Test
	public void testFindShortPath() throws IOException {
		TSP tsp = new TSP();
		File testFileName = new File("./Graph/graphTSP.txt");
		File OutFileName = new File("./Graph/tspout.txt");
		String result = tsp.readFile(testFileName);
		ArrayList<String> path = tsp.findTSP(result);
		tsp.writeFile(OutFileName, path);
	}

	@Test
	public void assertReaders() throws IOException {
		BufferedReader expected = new BufferedReader(new FileReader(
				"./Graph/expectedtspout.txt"));
		BufferedReader actual = new BufferedReader(new FileReader(
				"./Graph/tspout.txt"));
		String line;
		while ((line = expected.readLine()) != null) {
			assertEquals(line, actual.readLine());
		}

		assertNull("Actual had more lines then the expected.",
				actual.readLine());
		assertNull("Expected had more lines then the actual.",
				expected.readLine());
	}
}
