import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CityTournamentPopulation {

	public static void main(String[] args) {
		CityGraph c  = new CityGraph();
		/*c.connect(1, 5);
	    c.connect(4, 5);
	    c.connect(3, 5);
	    c.connect(2, 5);
	    c.connect(2, 15);
	    c.connect(2, 7);
	    c.connect(7, 8);
	    c.connect(8, 38);*/
		c.connect(1, 5);
		c.connect(4, 5);
		c.connect(5, 2);
		c.connect(5, 3);
		//c.printGraph();
		//c.printPopulation();
		//c.printmaxNeighbourCount();
		c.maxNeighbourCountSolver(5);
		System.out.println("\n\nEnd of problem");
	}
	
}

//Note : Solution is correct when all city population are distinct
//https://www.careercup.com/question?id=5695046734053376

class CityGraph{
	HashMap<Integer,List<Integer>> vertex;
	HashMap<Integer,Integer> population;
	HashMap<Integer,Integer> maxNeighbourCount;
	HashMap<Integer,Boolean> visited;
	CityGraph(){
		vertex = new HashMap<>();
		population = new HashMap<>();
		maxNeighbourCount = new HashMap<>();
	}
	public void maxNeighbourCountSolver(int start) {
		System.out.println("Started solving max neighbour problem\n");
		visited = new HashMap<>();
		firstSweep(start);
		//printPopulation();
		//System.out.println(start + " " + maxNeighbourCount.get(start));
		visited = new HashMap<>();
		getMaxNeighbourCount(start,0);
		printmaxNeighbourCount();
		
	}
	public void getMaxNeighbourCount(int start, int prev) {
		visited.put(start, true);
		int diff = prev-population.get(start);
		if(diff > maxNeighbourCount.get(start)){
			maxNeighbourCount.put(start, diff);
		}
		if(diff>0){
			population.put(start, population.get(start)+diff);
		}
		for(int child:vertex.get(start)){
			if(visited.get(child)==null){
				getMaxNeighbourCount(child,population.get(start));
			}
		}
		
	}
	int firstSweep(int start){
		visited.put(start, true);
		for(int child:vertex.get(start)){
			if(visited.get(child)==null){
				int populationFromChild=firstSweep(child);
				population.put(start, population.get(start)+populationFromChild);
				if(populationFromChild>maxNeighbourCount.get(start)){
					maxNeighbourCount.put(start, populationFromChild);
				}
			}
		}
		return population.get(start);
	}
	void connect(int start,int end){
		
		if(vertex.get(start)==null){
			population.put(start, start);
			maxNeighbourCount.put(start, 0);
			List<Integer> edge = new ArrayList<>();
			edge.add(end);
			vertex.put(start, edge);
		}else{
			vertex.get(start).add(end);
		}
		if(vertex.get(end)==null){
			population.put(end, end);
			maxNeighbourCount.put(end, 0);
			List<Integer> edge = new ArrayList<>();
			edge.add(start);
			vertex.put(end, edge);
		}else{
			vertex.get(end).add(start);
		}
	}
	
	void printGraph(){
		vertex.forEach((k,v)->System.out.println(k + " :: " + v));
	}
	void printPopulation(){
		population.forEach((k,v)->System.out.println("City " + k + " Population " + v));
	}
	void printmaxNeighbourCount(){
		maxNeighbourCount.forEach((k,v)->System.out.println("City " + k + " MaxNeighbourCount " + v));
	}
}