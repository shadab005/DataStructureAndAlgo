package fkart.test;

import fkart.smake.SimpleMake;

public class SimpleMakeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();

	}
	
	public static void test1(){
		SimpleMake sm = new SimpleMake("test.txt");
		sm.execute("smake say_hi");
		
	}

}
