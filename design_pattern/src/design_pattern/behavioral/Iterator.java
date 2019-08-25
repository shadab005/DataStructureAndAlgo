package design_pattern.behavioral;

/*
 * Iterator is a behavioral design pattern that lets you traverse elements of a 
 * collection without exposing its underlying representation (list, stack, tree, etc.).
 * 
 * interface Iterator : +next(), +hasNext()
 * class ConcreteIterator extends Iterator
 * interface Aggregate : +createIterator
 * class ConcreteAggregate implements Aggregate
 * 
 * Note: 
 * The ConcreteAggregate has a collection of objects and implements the method that returns an Iterator for its collection
 * Returns ConcreteIterator on createIterator
 */

public class Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
