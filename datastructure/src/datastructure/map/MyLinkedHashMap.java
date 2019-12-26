package datastructure.map;

import java.util.HashMap;

public class MyLinkedHashMap<K extends Comparable<K>, V> {

	static class Node<K, V> {
		public Node(K key, V val) {
			this.key = key;
			this.value = val;
		}

		K key;
		V value;
		Node<K, V> next;
		Node<K, V> prev;
	}

	HashMap<K, Node<K, V>> map;
	Node<K, V> first;
	Node<K, V> last;

	MyLinkedHashMap() {
		map = new HashMap<>();
		first = new Node<>(null, null);
		last = first;
		map.put(null, first);
	}

	public void remove(K key) {
		if (key == null)
			throw new IllegalArgumentException("Key cannot be null");
		if (map.containsKey(key)) {
			Node<K, V> current = map.get(key);
			Node<K, V> prev = current.prev;
			Node<K, V> next = current.next;
			if (current == last) {
				last = prev;
				prev.next = null;
			} else {
				prev.next = next;
				next.prev = prev;
			}
			map.remove(key);
		}
	}

	public void put(K key, V val) {
		remove(key);
		Node<K, V> current = new Node<>(key, val);
		last.next = current;
		current.prev = last;
		last = current;
		map.put(key, current);

	}

	public V get(K key) {
		if (map.get(key) == null)
			return null;
		return map.get(key).value;
	}

	public K getFirstKey() {
		if (first.next == null)
			return null;
		return first.next.key;
	}

	public V getFirstVal() {
		if (first.next == null)
			return null;
		return first.next.value;
	}

	public K getLastKey() {
		return last.key;
	}

	public V getLastVal() {
		return last.value;
	}
}