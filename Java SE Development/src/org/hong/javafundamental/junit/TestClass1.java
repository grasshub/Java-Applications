package org.hong.javafundamental.junit;

import java.util.Arrays;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestClass1 {
	
	@Test
	public void testMatchers() {
		
		Integer a = new Integer(1);
		Integer b = a;
		Integer c = new Integer(2);
		
		assertThat(a, sameInstance(b));
		assertThat(a, notNullValue(Integer.class));
		assertThat(a, not(c));
		assertThat(a, instanceOf(Integer.class));
		assertThat(a, equalTo(b));
		assertThat(a, any(Integer.class));
		assertThat(a, is(b));
		assertThat(a, anyOf(is(c), not(c)));
		assertThat(a, allOf(is(b), not(c)));
		
		assertThat("Good Morning", both(containsString("Good")).and(containsString("Morn")));
		assertThat("Good Morning", both(startsWith("Good")).and(endsWith("Morning")));
		assertThat("Good Morning", either(containsString("Good")).or(containsString("Bye")));
		
		assertThat(Arrays.asList("Good", "Goody", "Google"), everyItem(startsWith("Goo")));
		assertThat(Arrays.asList("Good", "Goody", "Google"), hasItem(containsString("gle")));
	}

}
