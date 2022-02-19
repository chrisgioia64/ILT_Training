package lecture11;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Test2 {
	
	@Test
	public void test1() {
		// using suite timeout of 500ms; this should pass
		assertTrue(true);
	}
	
	@Test
	public void test2() throws InterruptedException {
		// using suite timeout of 500ms; this should fail
		Thread.sleep(1000);
	}
	
	@Test(timeOut=200)
	public void test3() {
		// using method timeout of 200; this should pass
		assertTrue(true);
	}
	
	@Test(timeOut=200)
	public void test4() throws InterruptedException {
		// using method timeout of 200; this should fail
		Thread.sleep(300);
		assertTrue(true);
	}
	
}
