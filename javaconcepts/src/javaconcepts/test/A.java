package javaconcepts.test;


class A
{
	static void fun(){
		System.out.println("Fun in A");
	}
	
	
	void f1(){
		System.out.println("In A f1");
		f2();
	}
	
	void f2(){
		System.out.println("kjsjs");
	}
}

class B extends A{

	static void fun(){
		System.out.println("Fun in B");
	}
	
	void f2(){
		System.out.println("bbbbbbb");
	}
	
}

