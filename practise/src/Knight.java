import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Knight {

	static int xmov[]= {-2,-2,-1,-1,1,1,2,2};
	static int ymov[]= {-1,1,2,-2,2,-2,1,-1};
	
	public int knight(int n, int m, int x, int y, int a, int b) {
        
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Pair> visited = new HashSet<>();
        queue.add(new Pair(x,y));
        visited.add(new Pair(x,y));
        Pair p = null;
        Pair target = new Pair(a,b);
        int count = 0;
        boolean found = false;
        while(!queue.isEmpty() &&!found) {
        	int t = queue.size();
        	count++;
        	while(t-->0) {
	        	p = queue.remove();
	        	if(p.equals(target)) {
	        		found = true;
	        		break;
	        	}
	        	for(int i=0;i<8;i++) {
	        		int xNeighbour = p.x+xmov[i];
	        		int yNeighbour = p.y+ymov[i];
	        		if(xNeighbour>0 && xNeighbour<=n && yNeighbour>0 && yNeighbour<=m) {
	        			Pair neigbour = new Pair(xNeighbour, yNeighbour);
	        			if(!visited.contains(neigbour)) {
	        				queue.add(neigbour);
	        				visited.add(neigbour);
	        			}
	        		}
	        	}
        	}
        }
        if(found) return count-1;
        return -1;
	}
	
	private static class Pair{
		int x, y;
		Pair(int a,int b){
			x=a;y=b;
		}
		
		@Override
		public boolean equals(Object o2) {
			 return x == ((Pair)o2).x && y == ((Pair)o2).y;
		}
		
		@Override
		public int hashCode() {
			int hash = 17;
			hash = hash * 31 + x;
		    hash = hash * 31 + y;
			return hash;
		}
	}
	public static void main(String[] args) {
		HashSet<Pair> visited = new HashSet<>();
		visited.add(new Pair(1,3));
		System.out.println(visited.contains(new Pair(1,3)));
	}
}
