package lecture11;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftHardAssertTest {
	
	@Test
	public void testHardAssert() {
		Assert.assertEquals("foo", "bar");
		Assert.assertEquals("foo", "foo");
		Assert.assertEquals("bar", "foo");
	}
	
	@Test
	public void testSoftAssert() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("foo", "bar");
		softAssert.assertEquals("foo", "foo");
		softAssert.assertEquals("bar", "foo");
		softAssert.assertAll();
	}

}
