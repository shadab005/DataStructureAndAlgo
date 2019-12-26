package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import algo.util.Util;

public class StudentAverageScore {

	public static void main(String[] args) {
		int a[][] = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		int ans[][] = highFive(a);
		Util.printArray(ans);

	}
	
    static public int[][] highFive(int[][] items) {
        
    	HashMap<Integer, List<Integer>> map = new HashMap<>();
    	
    	for(int i = 0; i<items.length; i++) {
    		int id = items[i][0];
    		int score = items[i][1];
    		List<Integer> l = map.getOrDefault(id, new ArrayList<>());
    		l.add(score);
    		map.put(id, l);
    	}
    	int numStudent = map.keySet().size();
    	int ans[][] = new int[numStudent][2];
    	int k = 0;
		for (Map.Entry<Integer,List<Integer>> entry : map.entrySet().stream().sorted((x,y)->x.getKey()-y.getKey()).collect(Collectors.toList())) {
			int id = entry.getKey();
			List<Integer> scores = entry.getValue();
			int avg = (int)scores.stream().sorted((x,y)->y-x).limit(5).mapToInt(i->i).average().getAsDouble();
			ans[k][0] = id;
			ans[k][1] = avg;
			k++;
		}
    	return ans;
    }

}
