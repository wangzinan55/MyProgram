package newSort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;


public class ShellsortTest {
	@Test
	public void testSort_1()
		throws Exception {
		int[] a = new int[] {};
		Shellsort shsort = new Shellsort();
		
		String [] result= shsort.sort(a).split("\n");

		// add additional test code here
		assertNotNull(result);
		//assertEquals(0, a.length);
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
		int[] a = new int[] {12,11,4,3,1};
		Shellsort shsort = new Shellsort();

		//int[] result = Shellsort.sort(a);
		String [] res= shsort.sort(a).split("\n");
		
		Assert.assertEquals(1, a[0]);
		Assert.assertEquals(3, a[1]);
		Assert.assertEquals(4, a[2]);
		Assert.assertEquals(11,a[3]);
		Assert.assertEquals(12,a[4]);
		Assert.assertEquals("4\t11\t12\t3\t1", res[0]);
		Assert.assertEquals("4\t3\t12\t11\t1", res[1]);
		Assert.assertEquals("1\t3\t4\t11\t12", res[2]);
		Assert.assertEquals("1\t3\t4\t11\t12", res[3]);
		Assert.assertEquals("1\t3\t4\t11\t12", res[4]);
		Assert.assertEquals("1\t3\t4\t11\t12", res[5]);
		Assert.assertEquals("1\t3\t4\t11\t12", res[6]);
		//Assert.assertEquals("0\t2\t1",res[0]);
		//Assert.assertEquals("0\t1\t2",res[1]);
		
		// add additional test code here
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

		String[] result = Shellsort.sort(a).split("\n");
		
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
		new org.junit.runner.JUnitCore().run(BubbleSortTest.class);
	}

}
