package com.sg.hamcrest.test;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.everyItem;






public class HamcrestTest1 {

	@Test
	public void test() {
		
		List<Integer> scores =  Arrays.asList(100, 200, 300, 400);
		List<String> names= Arrays.asList("bar", "baar");
		
		assertThat(scores, hasItems(100,200));
	//	assertThat(scores, everyItem(lessThan(190)));
		
		
	}

}
