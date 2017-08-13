import java.util.Scanner;

public class GraphComponents {

	int numChild[];
	int id[];
	int N;

	/*
	 * for n = 5 -> 1 to 10
	 */
	public GraphComponents(int n) {
		N = 2 * n + 1;
		numChild = new int[N];
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int root(int i) { // Path compression technique applied
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public void union(int i, int j) {
		int rooti = root(i);
		int rootj = root(j);
		if (rooti == rootj)return;

		if (numChild[rooti] <= numChild[rootj]) {
			numChild[rootj] += numChild[rooti]+1;
			id[rooti] = rootj;
		} else {
			numChild[rooti]+=numChild[rootj]+1;
			id[rootj]=rooti;
		}
	}
	
	public void getMinMaxComponentNodeCount(){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 1 ;i < N ; i++){
			if(id[i]==i && numChild[i]>0){
				if(min > numChild[i]+1)min = numChild[i]+1;
				if(max < numChild[i]+1)max = numChild[i]+1;
			}
		}
		
		System.out.println(min+" "+max);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		GraphComponents g = new GraphComponents(n);
		while(n-->0){
			g.union(in.nextInt(), in.nextInt());
		}
		
		//Util.printArray(g.id);
		//Util.printArray(g.numChild);
		//System.out.println("Solving");
		g.getMinMaxComponentNodeCount();
		in.close();

	}

}
