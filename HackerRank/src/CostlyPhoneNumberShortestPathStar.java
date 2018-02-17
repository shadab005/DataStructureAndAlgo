import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 * https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms
 * /practice-problems/algorithm/costly-phone-number-december-easy-easy-medium/description/
 */
public class CostlyPhoneNumberShortestPathStar {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int c[] = new int[10];
		int length = 0;
		while (t-- > 0) {
			for (int i = 0; i < 10; i++)c[i] = in.nextInt();
			
			length = in.nextInt();
			String phone = in.next();
			solve(c, length, phone);
		}
		in.close();

	}

	static void solve(int[] c, int length, String phone) {
		//System.out.println("solving");
		int g[][] = new int[11][11];
		// constructing graph
		buildGraph(g, c);
		//System.out.println("Graph built");
		//Util.printArray(g);
		int distance[]=new int[11];
		dijkstra(g, distance, 10);
		//System.out.println("Graph shortest path calculated");
		//Util.printArray(distance);
		
		int ans = 0;
		int x = 0;
		while(length>0) {
			length--;
			x = Integer.parseInt(phone.charAt(length)+"");
			ans+=distance[x];
		}
		System.out.println(ans);
	}

	private static void dijkstra(int[][] g, int distance[],  int source) {
		int size = 11;
		Arrays.fill(distance, Integer.MAX_VALUE);
		int closest[] = new int[11];
		Arrays.fill(closest, -1);
		
		boolean visited[]=new boolean[size];
		for(int i=0;i<size;i++) {
			distance[i]=g[source][i];
			closest[i]=source;
		}
		distance[source]=0;
		visited[source]=true;
		
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i=1;i<size;i++) {
			min= Integer.MAX_VALUE;
			for(int j=0;j<size-1;j++) {
				if(!visited[j]) {
					if(distance[j]<min) {
						min = distance[j];
						minIndex = j;
					}
				}
			}
			visited[minIndex]=true;
			for(int k=0;k<size-1;k++) {
				if(!visited[k]) {
					if(distance[k]>distance[minIndex]+g[minIndex][k]) {
						distance[k]=distance[minIndex]+g[minIndex][k];
						closest[k]=minIndex;
					}
				}
			}
		}
		//printAllShortestPath(closest, source, distance);
	}
	
	private static void printAllShortestPath(int closest[], int source, int distance[]) {
		System.out.println("Printing All shortest path");
		for(int i=0;i<10;i++) {
			printShortestPath(closest, source, i, distance);
		}
	}
	
	private static void printShortestPath(int closest[], int source, int destination, int distance[]) {
		Stack<Integer> s = new Stack<>();
		int element = destination;
		while(element!=source){
			s.push(element);
			element = closest[element];
		}
		s.push(element);
		System.out.println("Source = " + source + " Desitination = " + destination +" Distance = " + distance[destination]);
		while(!s.isEmpty()){
			System.out.print(s.pop() + " ");
		}
		System.out.println();
	}

	private static void buildGraph(int[][] g, int[] c) {
		int temp = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				g[i][j]=Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				temp = (i + j) % 10;
				if (temp == i) {
					g[i][i] = 0;
				}else {
					g[i][temp] = c[j];
				}
			}
		}
		for(int i=0;i<10;i++) {
			g[10][i]=c[i];
		}
		g[10][10]=0;
	}

}
