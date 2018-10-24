package newSort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>BubbleSortTest</code> contains tests for the class <code>{@link BubbleSort}</code>.
 *
 * @generatedBy CodePro at 15/07/01 19:26
 * @author super
 * @version $Revision: 1.0 $
 */
public class HeapSortTest {
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

		int[] result = HeapSort.sort(a);  

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
		int[] a = new int[] {1, 10, 1, 13, 111, 2250, 1234, 567, 0, 21, -33121, -40};

		int[] result = HeapSort.sort(a);

		// add additional test code here
		assertNotNull(result);
		assertEquals(12, result.length);
		assertEquals(-33121, result[0]);
		assertEquals(-40, result[1]);
		assertEquals(0, result[2]);
		assertEquals(1, result[3]);
		assertEquals(1, result[4]);
		assertEquals(10, result[5]);
		assertEquals(13, result[6]);
		assertEquals(21, result[7]);
		assertEquals(111, result[8]);
		assertEquals(567, result[9]);
		assertEquals(1234, result[10]);
		assertEquals(2250, result[11]);
	}
	/**
	 * Run the int[] sort(int[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15/07/01 19:26
	 */
	
	@Test(expected = NullPointerException.class)
	public void testSort_3()
		throws Exception {
		int[] a = null;

		int[] result = HeapSort.sort(a);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(HeapSortTest.class);
	}
}