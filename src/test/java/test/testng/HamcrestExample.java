package test.testng;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HamcrestExample {

	@Test
	public void testInteger() {
		assertThat("integer same", 1, Matchers.equalTo(2));
		assertEquals(true, true);
	}
	
	@Test
	public void testString() {
		assertThat("string same", "Hello", Matchers.equalTo("Hello"));
		assertThat("hello", Matchers.equalToIgnoringCase("Hello"));
	}
	
	@Test
	public void testList() {
		List<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		assertThat(list, Matchers.contains(2, 3, 4));
//		assertThat(list, Matchers.empty());
		assertThat(list, Matchers.hasItems(3, 5));
	}
	
	@Test
	public void testEmptyCollection() {
		List<Integer> list = new LinkedList<>();
		assertThat(list, Matchers.empty());
	}
	
	@Test
	public void testPerson() {
		Person p1 = new Person("Chris", 29, "Richmond");
		Person p2 = new Person("John", 64, "Richmond");
		Person p3 = new Person("Maria", 59, "Walnut Creek");
		Person p4 = new Person("Chris", 29, "Richmond");
		assertThat(p1, Matchers.allOf(Matchers.sameInstance(p1), Matchers.notNullValue()));
		
		assertThat(p1, Matchers.equalTo(p4));
	}
	
	
}
