package javaconcepts.generics;

import java.util.List;

public class Practise {

	public static <T> void exchange(T[] a, T[] b) {
		for (int i = 0; i < a.length && i < b.length; i++) {
			T temp = a[i];
			a[i] = b[i];
			b[i] = temp;
		}
	}
	
	public static <T extends Comparable<? super T>> T maxElementInList(List<? extends T> l){
		T max = l.get(0);
		for(T t : l){
			if(t.compareTo(max) > 0) max = t;
		}
		return max;
	}

	public static void main(String args[]) {
		Double[] d1 = { 1.0, 2.0 };
		Double[] d2 = { 3.0, 4.0 };
		print(d1);
		print(d2);
		exchange(d1, d2);
		print(d1);
		print(d2);
		System.out.println();
	}

	public static <T> void print(T[] t) {
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + " ");
		}
		System.out.println();
	}
}
