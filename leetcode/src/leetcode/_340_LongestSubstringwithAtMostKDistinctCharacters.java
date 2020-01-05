package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class _340_LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
	
	}
	
	static public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Set<Character> set = new HashSet<>();
		int ans = Math.min(s.length(), k);
		int i = 0, j =0;
		MyLinkedHashMap<Character, Integer> lhm = new MyLinkedHashMap<>();
		//Map of Character to last index
		while(j<s.length()) {
			set.add(s.charAt(j));
			lhm.put(s.charAt(j), j);
			if(set.size() > k) {
				//remove a character from this set which has the minimum lastIndex
				Character c = lhm.getFirstKey();
				Integer lastIndex = lhm.getFirstVal();
				//update index i to the above lastIndex+1
				i=lastIndex+1;
				set.remove(c);
				lhm.remove(c);
			}
			ans = Math.max(ans, j-i+1);
			j++;
		}
		return ans;
    }
	
	
	
	static class MyLinkedHashMap <K extends Comparable<K>,V>{
		
		static class Node<K,V>{
			public Node(K key, V val) {
				this.key = key;
				this.value = val;
			}
			K key;
			V value;
			Node<K,V> next;
			Node<K,V> prev;
		}
		
		HashMap<K,Node<K,V>> map;
		Node<K,V> first;
		Node<K,V> last;
		
		MyLinkedHashMap() {
			map = new HashMap<>();
			first = new Node<>(null,null);
			last = first;
			map.put(null, first);
		}
		
		public void remove(K key) {
			if(key == null) throw new IllegalArgumentException("Key cannot be null");
			if(map.containsKey(key)) {
				Node<K,V> current = map.get(key);
				Node<K,V> prev = current.prev;
				Node<K,V> next=current.next;
				if(current == last) {
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
			if(map.get(key)==null) return null;
			return map.get(key).value;
		}
		
		public K getFirstKey() {
			if(first.next==null) return null;
			return first.next.key;
		}
		
		public V getFirstVal() {
			if(first.next == null) return null;
			return first.next.value;
		}
		
		public K getLastKey() {
			return last.key;
		}
		
		public V getLastVal() {
			return last.value;
		}
	}
	

}
