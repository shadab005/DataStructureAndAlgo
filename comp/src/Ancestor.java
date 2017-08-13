import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Ancestor {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int x = 0 , y =0;
		while(t-->0){
			int n = in.nextInt();
			Graph g = new Graph(n+1);
			int parent[]=new int[n+1];
			for(int i=1;i<n;i++){
				x =in.nextInt();
				y= in.nextInt();
				g.connect(x, y);
			}
			
			g.makeParentGraph(parent);
			//System.out.println("Done parenting");
			
			/*for(int i=1;i<=n;i++){
				System.out.println(parent[i]+" ");
			}*/
			
			int parent2[]=new int[n+1];
			Graph gg = new Graph(n+1);
			for(int i=1;i<n;i++){
				x =in.nextInt();
				y= in.nextInt();
				gg.connect(x, y);
			}
			gg.makeParentGraph(parent2);
			
			
			HashMap<Integer, Set<Integer>> a = new HashMap<>();
			HashMap<Integer, Set<Integer>> b = new HashMap<>();
			for(int i=2;i<=n;i++){
				a.put(i, calculate(i, a, parent));
				b.put(i, calculate(i, b, parent2));
			}
			
			/*for(int i=1;i<=n;i++){
				Set<Integer> ss = a.get(i);
				System.out.println(ss);
			}
			
			for(int i=1;i<=n;i++){
				Set<Integer> ss = b.get(i);
				System.out.println(ss);
			}*/
			//System.out.print(0 +" ");
			for(int i=1;i<=n;i++){
				Set<Integer> z = a.get(i);
				if(z!=null){
				   if(b.get(i)!=null){
                       z.retainAll(b.get(i));					   
					   System.out.print(z.size()+" ");
				   }else{
					   System.out.print(0 + " ");   
				   }
				}else{
					System.out.print(0 + " ");
				}
			}
			System.out.println();
			
		}
		in.close();
	}

	private static Set<Integer> calculate(int j, HashMap<Integer, Set<Integer>> a, int parent[]) {
		if(j==1){
		   HashSet<Integer> x = new HashSet<>();
		   x.add(1);
		   return x;
		}
		else if(a.get(j)!=null){
		    return a.get(j);	
		}
		Set<Integer> s = new HashSet<>(calculate(parent[j], a, parent));
		s.add(parent[j]);
	//	s.add(j);
		return s;
	}
	
	static class Graph {

		ArrayList<List<Integer>> vertex;
		int n=0;
		Graph(int n){
			this.n=n;
			vertex = new ArrayList<>();
	        for(int i = 0;i<=n;i++)vertex.add(new ArrayList<>());
		}
		public void makeParentGraph(int[] parent) {
			visited = new boolean[n+1];
			for(int i=1;i<=n;i++){
			  if(!visited[i]){
				  parenting(i,parent);
			  }
			}
			
		}
		private void parenting(int id, int[] parent) {
			visited[id]=true;
			//System.out.println(id);
			for(int x:vertex.get(id)){
				if(!visited[x]){
					parenting(x,parent);
				}else if(parent[id]==0){
					parent[id]=x;
				}
			}
			
		}
		boolean visited[];
		/*public void depthFirstTraversal(){
			int count=0;
			visited=new boolean[n];
			for(int i=0;i<n;i++){
				if(!visited[i]){
					count++;
					dfs(i);
				}
			}
			System.out.println();
			System.out.println("Number of components in graph = " + count);
		}
		
		public void dfs(int id){
			System.out.print(id + " ");
			visited[id]=true;
			for(int x:vertex.get(id)){
				if(!visited[x])dfs(x);
			}
		}*/
		public void connect(int first,int second){
			vertex.get(first).add(second);
			vertex.get(second).add(first);
		}

	}

}

