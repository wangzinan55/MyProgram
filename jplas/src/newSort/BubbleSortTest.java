package newSort;

import org.junit.Assert;
import org.junit.Test;



public class BubbleSortTest {
	@Test
	public void testSort_2()
		throws Exception {
		int[] a = new int[] {1, 0};
		BubbleSort bsort = new BubbleSort();

		String[] res = bsort.sort(a).split("\n");

		Assert.assertEquals(0,a[0]);
		Assert.assertEquals("0\t1",res[0]);
	}
	@Test
	public void testSort_3()
		throws Exception {
		int[] a = new int[] {2, 0, 1};
		BubbleSort bsort = new BubbleSort();

		String[] res = bsort.sort(a).split("\n");

		Assert.assertEquals(0,a[0]);
		Assert.assertEquals(1,a[1]);
		Assert.assertEquals(2,a[2]);
		Assert.assertEquals("0\t2\t1",res[0]);
		Assert.assertEquals("0\t1\t2",res[1]);
	}
	@Test
	public void testSort_4()
		throws Exception {
		int[] a = new int[] {2, 3, 0, 1};
		BubbleSort bsort = new BubbleSort();

		String[] res = bsort.sort(a).split("\n");

		Assert.assertEquals(0,a[0]);
		Assert.assertEquals(1,a[1]);
		Assert.assertEquals(2,a[2]);
		Assert.assertEquals("0\t2\t3\t1",res[0]);
		Assert.assertEquals("0\t1\t2\t3",res[1]);
		Assert.assertEquals("0\t1\t2\t3",res[2]);
	}
	

}
