public class Test {

	public static void main(String[] args) throws InterruptedException {
		Test t = new Test();
		A a = new A();
		A b = new B();
		A c = new C();

		t.test(a);
		t.test(b);
		t.test(c);

	}

	public void test(A a) {
		System.out.println("IN A");
	}

	public void test(B b) {
		System.out.println("IN B");
	}

	public void test(C c) {
		System.out.println("IN C");
	}

}

class A {

}

class B extends A {

}

class C extends A {

}