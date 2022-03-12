package javaconcepts.generics.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author shassan
 *
 * To write selecter
 * What Selector does is checking all the elements in a collection and takes only the ones that meet the given Condition.
 * I wanted to have only one Selector that can easily deal with all the classes extends
 * Collection instead of having one for each (e.g. ListToArrayListSelector, ListToHashSetSetSelector, SetToListSelector, and so on).
 */
public class Example2 {

	//Approach one
	public void usage() {
		List<Product> productList = new ArrayList<>();
		Condition<Product> myCondition = p -> p.getPrice().doubleValue() > 100;

		MySelector<Product, HashSet<Product>> mySelector = new MySelector<>();

		HashSet<Product> list = mySelector.select(productList, myCondition);
		System.out.println(list);
	}

	static class MySelector <E, T extends Collection<E>>{

		public T select(Iterable<? extends E> list, Condition<? super E> c) {
			T result = null; //Create object of result
			for(E e : list) {
				if(c.test(e))result.add(e);
			}
			return result;
		}
	}

	//Approach two

	public void usageTwo() {
		List<Product> productList = new ArrayList<>();
		Condition<Product> myCondition = p -> p.getPrice().doubleValue() > 100;
		SelectorImpl<Product, List<Product>, Condition<Product>, ArrayList<Product>> selector = new SelectorImpl<>(new ArrayListCreator<Product>());
		ArrayList<Product> l = selector.select(productList, myCondition);
		System.out.println(l);
	}

	//Approach 2 improvement

	public void usageTwoImprov() {

		List<Product> productList = new ArrayList<>();
		Condition<Product> myCondition = p -> p.getPrice().doubleValue() > 100;
		IterableToArrayListSelector<Product> selector = CollectionUtil.getIterableToArraySelector();
		ArrayList<Product> filteredProduct = selector.select(productList, myCondition);
		System.out.println(filteredProduct);
	}


	static class SelectorImpl<E,
	                   T extends Iterable<? extends E>,
	                   C extends Condition<? super E>,
	                   R extends Collection<E>>
	implements Selector<T,C,R>{

		private final CollectionCreator<E, ? extends R> collectionCreator;

		public SelectorImpl(CollectionCreator<E, ? extends R> cc) {
			this.collectionCreator = cc;
		}

		@Override
		public R select(T source, C condition) {
		    R result = collectionCreator.createCollection();
		    for(E e: source) {
		    	if(condition.test(e))result.add(e);
		    }
			return null;
		}
	}

	static class IterableToArrayListSelector<E> extends SelectorImpl<E, Iterable<E>, Condition<? super E>, ArrayList<E>>{

		public IterableToArrayListSelector(final ArrayListCreator<E> collectionCreator) {
			super(collectionCreator);
		}

	}

	interface CollectionCreator<E, T extends Collection<? extends E>> {
		public T createCollection();
	}

	static class ArrayListCreator<E> implements CollectionCreator<E, ArrayList<E>>{
		@Override
		public ArrayList<E> createCollection() {
			return new ArrayList<>();
		}
	}

	static class CollectionUtil{

		public static <E> IterableToArrayListSelector<E	> getIterableToArraySelector(){
			return new IterableToArrayListSelector<>(new ArrayListCreator<E>());
		}
	}

	interface Selector<T, C, R>{
		R select(T source, C condition);
	}

	static interface Condition<T> {
		boolean test(T imput);
	}


}
