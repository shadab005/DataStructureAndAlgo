import java.util.ArrayList;
import java.util.Scanner;

public class ConnectionPowerofCitiesDfs {

	static ArrayList<Integer>[] vertex;
	static boolean specialCities[];
	
	public static void main(String[] args) {
		new Thread(null,null,"1",0x999999)
        {
           public void run() 
           {
               try
               {
                   solve();
               }
               catch(Exception e)
               {   
                   e.printStackTrace();
                   System.exit(1);
               }
           }
        }.start();
	}
	
	@SuppressWarnings("unchecked")
	static void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x= in.nextInt();
		
		vertex = (ArrayList<Integer>[])new ArrayList[n+1];
		specialCities = new boolean[n+1];
		for(int i =0 ;i<m;i++) {
			vertex[i] = new ArrayList<>();
			specialCities[in.nextInt()]=true;
		}
		for(int i = m ;i<=n;i++) {
			vertex[i]= new ArrayList<>();
		}
		int first,second=0;
		for(int i=0;i<x;i++) {
		  	first = in.nextInt();
		  	second = in.nextInt();
		  	vertex[first].add(second);
		  	vertex[second].add(first);
		}
		
		findConnectionPower(n);
		in.close();
	}
	static long count = 0 ;
	static long connectionPower = 0;
	static boolean visited[];
	private static void findConnectionPower(int n) {
	  visited = new boolean[n+1];
	  long total = 0;
	  for(int i=1;i<=n;i++) {
		  if(!visited[i]) {
			  count = 0;
			  connectionPower = 0;
			  dfs(i);
			  total+=count*connectionPower;
		  }
	  }
	  System.out.println(total);
	}
	private static void dfs(int v) {
		visited[v]=true;
		count++;
		if(specialCities[v])connectionPower++;
		
		for(int e: vertex[v]) {
			if(!visited[e])dfs(e);
		}
	}

}
