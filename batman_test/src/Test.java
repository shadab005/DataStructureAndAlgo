import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hi");

		int numCompetitors = 5;
		int topNCompetitors = 2;
		List<String> competitors = Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
		int numReviews = 5;
		List<String> reviews = Arrays.asList("I love anacell Best services provided by anacell in the town",
				"betacellular has great services",
				"deltacellular provide much better services than betacellular",
				"cetracular is worse than eurocell",
				"betacellular is better than deltacellular");
		
		System.out.println(topNCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews));

	}

	static public ArrayList<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
			int numReviews, List<String> reviews) {
		
		Set<String> comps = new HashSet<>(competitors);

		Map<String, Integer> map = comps.stream().map(s->s.toLowerCase()).map(s->s.replaceAll(" ", "#")).collect(Collectors.toMap(s -> s, v -> 0));
		List<String> reviewsNew = new ArrayList<>();
		
		for(String s :reviews) {
			for(String cc : comps) {
				s = s.replaceAll(cc, cc.replaceAll(" ","#"));
			}
			reviewsNew.add(s);
		}
		
		for(String review : reviewsNew) {
			
			review = review.toLowerCase();
			review = review.replaceAll(";", " ");
			review = review.replaceAll(",", " ");
			String c[] = review.split(" ");
			HashSet<String> compNamesInReview = new HashSet<>();
			for(String cc : c) {
				if(map.containsKey(cc)) {
					if(!compNamesInReview.contains(cc)) {
						map.put(cc, map.get(cc)+1);
					}
					compNamesInReview.add(cc);
				}
			}
			//review = review.replaceAll(".", " ");
		}
		
		Comparator<Entry<String, Integer>> byCount  = (e1, e2) -> {
			if(e2.getValue() == e1.getValue()) {
				return e1.getKey().compareTo(e2.getKey());
			}
			return e2.getValue() - e1.getValue();
		};
		PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(byCount);
		
		for(Entry<String, Integer> e : map.entrySet()) {
			pq.add(e);
		}
		
		ArrayList<String>  ans = new ArrayList<>();
		for(int i = 0; i <topNCompetitors; i++) {
			Entry<String, Integer> e = pq.remove();
			if(e.getValue() == 0) break;
			ans.add(e.getKey().replaceAll("#", " "));
		}
		
		//System.out.println(map);
		return ans;
	}

}