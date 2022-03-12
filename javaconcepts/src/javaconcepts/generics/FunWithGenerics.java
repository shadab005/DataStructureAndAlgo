package javaconcepts.generics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FunWithGenerics {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		HashMap<String, Printer> map = new HashMap<>();
		map.put("A", new APrinter());
		map.put("B", new BPrinter());

		map.get("B").print(new B());

		ArrayList<A> list = new ArrayList<>();
		list.add(new B());
		list.add(new B());
		map.get("B").print(list);
	}

	static class A {
		String id = "A";
		void fun() {
			System.out.println("I am in A");
		}
	}

	static class B extends A{
		String id = "B";
		@Override
		void fun() {
			System.out.println("I am in B");
		}
	}

	static interface Printer<T extends A>{
		public void print(T o);
		public void print(List<T> o);
	}

	static class APrinter implements Printer<A>{
		@Override
		public void print(A o) {
			o.fun();
		}
		@Override
		public void print(List<A> o) {
			System.out.println("I am in list A printer@");
		}
	}

	static class BPrinter implements Printer<B>{
		@Override
		public void print(B o) {
			o.fun();
		}
		@Override
		public void print(List<B> o) {
			System.out.println("I am in list B printer");
		}
	}



}
