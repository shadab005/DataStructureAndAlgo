package com.demo;

public class StringConcatenate {
	
	public String concatenate(String s1, String s2) {
		if(s1!=null && s2!=null)return s1+s2;
		if(s1!=null)return s1;
		return s2;
	}

}
