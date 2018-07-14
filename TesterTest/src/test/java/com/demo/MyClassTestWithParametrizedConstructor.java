package com.demo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyClassTestWithParametrizedConstructor {

	public int m1;
	public int m2;
	public int result;
	
	public MyClassTestWithParametrizedConstructor(int x, int y, int z) {
		m1 = x;
		m2 = y;
		result = z;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
		return Arrays.asList(data);
	}
	    
	@Test
	public void multiply() {
		 MyClass tester = new MyClass();
	     Assert.assertEquals("Result", result, tester.multiply(m1, m2));
		
	}

}
