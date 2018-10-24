package newSort;
import org.junit.Assert;
import org.junit.Test;

public class QuickSort1Test {

	@Test
	public void testSort_2()
		throws Exception {
		int[] a = new int[] {1, 0};
		
		String[] res = QuickSort1.sort(a).split("\n");
		Assert.assertEquals(0,a[0]);
		Assert.assertEquals("0\t1",res[1]);
	}
	@Test
	public void testSort_3()
		throws Exception {
		int[] a = new int[] {2, 0, 1};

		String[] res = QuickSort1.sort(a).split("\n");
		Assert.assertEquals(0,a[0]);
		Assert.assertEquals(1,a[1]);    
		Assert.assertEquals(2,a[2]);
		Assert.assertEquals("2\t0\t1",res[0]);
		Assert.assertEquals("0\t1\t2",res[1]);
		Assert.assertEquals("0\t1\t2",res[2]);
	}
	@Test
	public void testSort_4()
		throws Exception {
		int[] a = new int[] {2, 3, 0, 1};

		String[] res = QuickSort1.sort(a).split("\n");
		Assert.assertEquals(0,a[0]);
		Assert.assertEquals(1,a[1]);
		Assert.assertEquals(2,a[2]);
		Assert.assertEquals("2\t3\t0\t1",res[0]);
		Assert.assertEquals("0\t1\t2\t3",res[1]);
		Assert.assertEquals("0\t1\t2\t3",res[2]);
		Assert.assertEquals("0\t1\t2\t3",res[3]);
		Assert.assertEquals("0\t1\t2\t3",res[4]);
	}
	@Test
	public void testSort_5()
		throws Exception {
		int[] a = new int[] {6, 9, 2, 3, 7, 10, 12, 3, 0, 1};

		String[] res = QuickSort1.sort(a).split("\n");
		Assert.assertEquals(0,a[0]);
		Assert.assertEquals(1,a[1]);
		Assert.assertEquals(2,a[2]);
		Assert.assertEquals(12,a[a.length-1]);
		System.out.println(res.length);
		Assert.assertEquals("6\t9\t2\t3\t7\t10\t12\t3\t0\t1",res[0]);
		Assert.assertEquals("0\t1\t2\t3\t7\t10\t12\t3\t6\t9",res[1]);
		Assert.assertEquals("0\t1\t2\t3\t7\t10\t12\t3\t6\t9",res[2]);
		Assert.assertEquals("0\t1\t2\t3\t7\t6\t3\t9\t10\t12",res[3]);
		Assert.assertEquals("0\t1\t2\t3\t7\t6\t3\t9\t10\t12",res[4]);
		Assert.assertEquals("0\t1\t2\t3\t7\t6\t3\t9\t10\t12",res[5]);
		Assert.assertEquals("0\t1\t2\t3\t3\t6\t7\t9\t10\t12",res[6]);
		Assert.assertEquals("0\t1\t2\t3\t3\t6\t7\t9\t10\t12",res[7]);
		Assert.assertEquals("0\t1\t2\t3\t3\t6\t7\t9\t10\t12",res[8]);
		Assert.assertEquals("0\t1\t2\t3\t3\t6\t7\t9\t10\t12",res[9]);
		Assert.assertEquals("0\t1\t2\t3\t3\t6\t7\t9\t10\t12",res[10]);
		Assert.assertEquals("0\t1\t2\t3\t3\t6\t7\t9\t10\t12",res[11]);
		Assert.assertEquals("0\t1\t2\t3\t3\t6\t7\t9\t10\t12",res[12]);
	}
}


