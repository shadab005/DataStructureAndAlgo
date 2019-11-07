package algo.common;

import java.util.HashMap;
import java.util.LinkedHashSet;

//Least Frequently Used cache
public class LFUCache {

	HashMap<Integer, Integer> keyValMap;
	HashMap<Integer, Integer> keyAccessFrequencyMap;
	HashMap<Integer, LinkedHashSet<Integer>> accessFrequencyToKeysMap;
	int capacity;
	int minAccessFrequency = -1;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		keyValMap = new HashMap<>();
		keyAccessFrequencyMap = new HashMap<>();
		accessFrequencyToKeysMap = new HashMap<>();
		accessFrequencyToKeysMap.put(1, new LinkedHashSet<>());
	}

	public int get(int key) {
		if (!keyValMap.containsKey(key)) return -1;
		int count = keyAccessFrequencyMap.get(key);
		keyAccessFrequencyMap.put(key, count + 1);
		accessFrequencyToKeysMap.get(count).remove(key);
		if (count == minAccessFrequency && accessFrequencyToKeysMap.get(count).size() == 0)
			minAccessFrequency++;
		if (!accessFrequencyToKeysMap.containsKey(count + 1))
			accessFrequencyToKeysMap.put(count + 1, new LinkedHashSet<>());
		accessFrequencyToKeysMap.get(count + 1).add(key);
		return keyValMap.get(key);
	}

	public void set(int key, int value) {
		if (capacity <= 0) return;
		if (keyValMap.containsKey(key)) {
			keyValMap.put(key, value);
			get(key);
			return;
		}
		if (keyValMap.size() >= capacity) {
			int evit = accessFrequencyToKeysMap.get(minAccessFrequency).iterator().next();
			accessFrequencyToKeysMap.get(minAccessFrequency).remove(evit);
			keyValMap.remove(evit);
		}
		keyValMap.put(key, value);
		keyAccessFrequencyMap.put(key, 1);
		minAccessFrequency = 1;
		accessFrequencyToKeysMap.get(1).add(key);
	}

}
