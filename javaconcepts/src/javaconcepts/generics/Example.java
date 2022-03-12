package javaconcepts.generics;

public class Example {

	public static void main(String[] args) throws InterruptedException {

		B b = new B();
		b.fun(new Y());
	}

}

class A <T extends X>{
	void fun(T x) {
		System.out.println("In fun A");
		x.f1();

	}
}

class B extends A <Y>{
	@Override
	void fun(Y y) {
		System.out.println("In fun B");
		y.f2();
	}
}

class X {
	void f1() {
	}
}

class Y extends X {

	@Override
	void f1() {
	}

	String f2() {
		return "y.f2()";
	}
}
