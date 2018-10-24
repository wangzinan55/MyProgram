package newSort;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class StackTest {

	@Test
	public void test1() {
		Stack s = new Stack();
		assertNotNull(s);
	}
	@Test
	public void test2() {
		Stack s = new Stack();
		s.push("a");
		Assert.assertEquals("a", s.pop());
	}
	@Test
	public void test3() {
		Stack s = new Stack();
		s.push(1);
		s.push(3);
		s.push(2);
		s.push(4);
		Assert.assertEquals(4, s.pop());
		Assert.assertEquals(2, s.pop());
		Assert.assertEquals(3, s.pop());
		Assert.assertEquals(1, s.pop());
	}
	@Test
	public void test4() {
		Stack s = new Stack();
		int[] a = new int[100];
		for(int index = 0; index < a.length; index++){
			a[index] = (int)(Math.random()*100);
		}
		for(int index = 0; index < a.length; index++){
			s.push(a[index]);
		}
		for(int index = a.length-1; index >= 0; index--){
			Assert.assertEquals(a[index], s.pop());
		}
	}
}
