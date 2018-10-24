package GraphtTestCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
public class PrimTest1 {
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testRead() throws IOException {
		File tempFile = tempFolder.newFile("tempFile.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
		bw.write("my test");
		bw.write("\n");
		bw.close();
		String expected = "my test\n";
		Prim prim = new Prim();
		String result = prim.readFile(tempFile);
		System.out.println(result);
		assertEquals(expected, result);
	}

	// compare output and expected output file
	@Test
	public void testFindShortPath() throws IOException {
		Prim prim = new Prim();
		File testFileName = new File("./Graph/graphPrim.txt");
		File OutFileName = new File("./Graph/primout.txt");
		String result = prim.readFile(testFileName);
		String[] path = prim.findNodesEdges(result);
		prim.writeFile(OutFileName, path);

	}

	@Test
	public void assertReaders() throws IOException {
		BufferedReader expected = new BufferedReader(new FileReader(
				"./Graph/expectedprimout.txt"));
		BufferedReader actual = new BufferedReader(new FileReader(
				"./Graph/primout.txt"));
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
		String[] s = new String[] { "a", "b", "c" };
		Prim prim = new Prim();
		prim.writeFile(tempFile, s);
		BufferedReader br = new BufferedReader(new FileReader(tempFile));
		String s1;
		boolean a = false;
		while ((s1 = br.readLine()) != null) {
			if (s1.contains("a"))
				a = true;
		}
		assertEquals(true, a);
		tempFile.delete();
	}
}
