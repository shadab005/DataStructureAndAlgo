package algo.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingJava {
	
	@SuppressWarnings("serial")
	static class LRUCache extends LinkedHashMap<Integer, Integer>{
	    private int capacity;
	    
	    public LRUCache(int capacity) {
	        super(capacity, 0.75F, true);
	        this.capacity = capacity;
	    }
	    public int get(int key) {
	        return super.getOrDefault(key, -1);
	    }
	    public void put(int key, int value) {
	        super.put(key, value);
	    }
	    @Override
	    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	        return size() > capacity; 
	    }
	}
	
	public static void main(String[] args) {
		LRUCache l = new LRUCache(1);
		l.put(2, 1);
		l.put(2, 2);
		System.out.println(l.get(2));
		l.put(1, 1);
		System.out.println(l.get(2));

	}

}
