package org.hong.javafundamental.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TestClass1 {
	static final String GOOD_MORNING = "Good Morning";
	
	@Test
	public void testMatchers() {
		
		Integer a = 1;
		Integer c = 2;

		assertThat(a, sameInstance(a));
		assertThat(a, notNullValue(Integer.class));
		assertThat(a, not(c));
		assertThat(a, instanceOf(Integer.class));
		assertThat(a, equalTo(a));
		assertThat(a, any(Integer.class));
		assertThat(a, is(a));
		assertThat(a, anyOf(is(c), not(c)));
		assertThat(a, allOf(is(a), not(c)));
		
		assertThat(GOOD_MORNING, both(containsString("Good")).and(containsString("Morn")));
		assertThat(GOOD_MORNING, both(startsWith("Good")).and(endsWith("Morning")));
		assertThat(GOOD_MORNING, either(containsString("Good")).or(containsString("Bye")));
		
		assertThat(Arrays.asList("Good", "Goody", "Google"), everyItem(startsWith("Goo")));
		assertThat(Arrays.asList("Good", "Goody", "Google"), hasItem(containsString("gle")));
	}

}
