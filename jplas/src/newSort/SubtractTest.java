package newSort;

import org.junit.Assert;
import org.junit.Test;


public class SubtractTest {
	@Test
	public void test1() {
		Substract substract = new Substract();
		int actual = substract.sub(10, 5);
		Assert.assertEquals(5, actual);
	}
	@Test
	public void test2() {
		Substract substract = new Substract();
		int r1 = (int)(100.0*Math.random());
		int r2 = (int)(100.0*Math.random());
		int actual = substract.sub(r1, r2);
		Assert.assertEquals(r1-r2, actual);
	}
}
