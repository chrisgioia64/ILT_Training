package lecture11;

import org.testng.annotations.Test;

public class Test1 {

	@Test(groups = {"arithmetic", "additive"})
	public void testAddition() {
	}

	@Test(groups = {"arithmetic", "additive"})
	public void testMultiplication() {
	}

	@Test(groups = {"arithmetic"})
	public void testSubtraction() {
	}
	
	@Test
	public void testFoo() {
	}
}
