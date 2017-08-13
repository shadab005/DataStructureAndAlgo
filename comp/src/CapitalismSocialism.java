import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class CapitalismSocialism {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int max=-1;
		int m=0,n=0;
		int a[][] = new int[500][500];
		ArrayList<Point> p = null;
		while(t-->0){
			n = in.nextInt();
			m = in.nextInt();
			max = -1;
			for(int i =0 ;i <n ; i++){
				for(int j=0;j<m;j++){
					a[i][j] = in.nextInt();
					if(a[i][j]>max){
						max= a[i][j];
						p = new ArrayList<>();
						p.add(new Point(i,j));
					}else if(a[i][j]==max){
						p.add(new Point(i,j));
					}
				}
			}
			findSolution(a,n,m,p, max);
		}
		in.close();
	}
	
	private static void findSolution(int[][] a, int n, int m, ArrayList<Point> p, int max) {
		if(p.size()==m*n){
			System.out.println(0);
			return;
		}
		int answer = -1;
		for(int i = 0; i<n;i++){
			for(int j=0;j<m;j++){
				if(a[i][j]!=max){
					int minFromAllMaxCordinate = calc(i,j,p);
					if(answer < minFromAllMaxCordinate){
						answer = minFromAllMaxCordinate;
					}
				}
			}
		}
		System.out.println(answer);
		
	}

	private static int calc(int i, int j, ArrayList<Point> p) {
		int min = 1000;
		for (Point point : p) {
			int d = d(i,j,point.x,point.y);
			if(min>d){
				min = d;
			}
		}
		return min;
	}

	static int d(int x1,int y1,int x2, int y2){
		return Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
	}

}

class Point{
	int x;
	int y;
	Point(int a, int b){
		x=a;
		y=b;
	}
	
}