package newSort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


@SuppressWarnings("deprecation")
public class QueTest {
	@Test
	public void test1() {
		Que q = new Que();
		assertNotNull(q);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void test2() {
		Que q = new Que();
		q.push("a");
		Assert.assertEquals("a", q.pop());
	}
	@Test
	public void test3() {
		Que q = new Que();
		q.push(1);
		q.push(3);
		q.push(2);
		q.push(4);
		Assert.assertEquals(1, q.pop());
		Assert.assertEquals(3, q.pop());
		Assert.assertEquals(2, q.pop());
		Assert.assertEquals(4, q.pop());
	}
	@Test
	public void test4() {
		Que q = new Que();
		int[] a = new int[100];
		for(int index = 0; index < a.length; index++){
			a[index] = (int)(Math.random()*100);
		}
		for(int index = 0; index < a.length; index++){
			q.push(a[index]);
		}
		for(int index = 0; index < a.length; index++){
			Assert.assertEquals(a[index], q.pop());
		}
	}
}
