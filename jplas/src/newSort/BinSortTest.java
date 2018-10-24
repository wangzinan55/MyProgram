package newSort;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>BubbleSortTest</code> contains tests for the class <code>{@link BubbleSort}</code>.
 *
 * @generatedBy CodePro at 15/07/01 19:26
 * @author super
 * @version $Revision: 1.0 $
 */
public class BinSortTest {
	int range = 100000;
	/**
	 * Run the int[] sort(int[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/07/01 19:26
	 */
	@Test
	public void testSort_1()
		throws Exception {
		int[] a = new int[] {};

		int[] result = BinSort.sort(a, range);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}
	/**
	 * Run the int[] sort(int[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/07/01 19:26
	 */
	@Test
	public void testSort_2()
		throws Exception {
		int[] a = new int[] {1, 0, 111, 2250, 13, 567, 1};

		int[] result = BinSort.sort(a, range);

		// add additional test code here
		assertNotNull(result);
		assertEquals(7, result.length);
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
		assertEquals(1, result[2]);
		assertEquals(13, result[3]);
		assertEquals(111, result[4]);
		assertEquals(567, result[5]);
		assertEquals(2250, result[6]);
	}
	/**
	 * Run the int[] sort(int[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/07/01 19:26
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testSort_3()
		throws Exception {
		int[] a = new int[] {1, 10, 1, 13, 111, 2250, 1234, 567, 0, 21, -33121, -40};

		int[] result = BinSort.sort(a, range);
		
		assertNull(result);
	}
	/**
	 * Run the int[] sort(int[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/07/01 19:26
	 */
	@Test(expected = NullPointerException.class)
	public void testSort_4()
		throws Exception {
		int[] a = null;

		int[] result = BinSort.sort(a, range);
		
		assertNull(result);
	}
	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15/07/01 19:26
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}
	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15/07/01 19:26
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}
	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 15/07/01 19:26
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BinSortTest.class);
	}
}
