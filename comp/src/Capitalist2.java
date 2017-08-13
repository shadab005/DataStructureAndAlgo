import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Capitalist2 {

	static class o {
		int d;
		int x;
		int y;


		o(int i, int a, int b) {
			d = i;
			x = a;
			y = b;
		}
		@Override
		public String toString() {
			return "o [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int max=-1;
		int m=0,n=0;
		int i,j;
		int vi[]={-1,0,1};
		int a[][] = new int[501][501];
		int temp[][] = new int[501][501];
		boolean visited[][] = new boolean[501][501];
		while(t-->0){
			n = in.nextInt();
			m = in.nextInt();
			max = -1;
			int x,y,d=0;
			for(i =0 ;i <n ; i++){
				for(j=0;j<m;j++){
                   a[i][j]=in.nextInt();
                   visited[i][j]=false;
                   max = Math.max(max, a[i][j]);
                   temp[i][j] = Integer.MIN_VALUE;
				}
			}
			Queue<o> q = new LinkedList<>();
			for( i =0 ;i <n ; i++)
				for( j=0;j<m;j++)
					if(a[i][j]==max){
						q.add(new o(0,i,j));
					}
			int c=0;
			while(!q.isEmpty()){
				o o1=q.remove();
				//System.out.println(o1.toString()+"  c="+c++ );
				//System.out.println(visited[o1.x][o1.y]);
				//System.out.println(q.toString());
				if(!visited[o1.x][o1.y]){
					temp[o1.x][o1.y]=o1.d;
					visited[o1.x][o1.y]=true;
					for(i=0;i<3;i++){
						for(j=0;j<3;j++){
							x=o1.x+vi[i];
							y=o1.y+vi[j];
							//System.out.println(x+" =x,y= "+y);
							if((x!=o1.x || y!=o1.y ) &&
								validate(x,y,n,m)== true &&
								visited[x][y]==false){
								//System.out.println("insering in queue "+x+" =x,y= "+y);
								q.add(new o(o1.d+1,x,y));
							}
						}
					}
				}else if(o1.d<temp[o1.x][o1.y]){
					temp[o1.x][o1.y]=d;
				}
				//System.out.println( temp[o1.x][o1.y] );
			}
			d=-1;
			for( i =0 ;i <n ; i++)
				for( j=0;j<m;j++)
					d=Math.max(d, temp[i][j]);
			System.out.println(d);
		}
		in.close();
	}

	public static boolean validate(int i, int j,int n, int m) {
		//System.out.println("inside validate "+i+" =x,y= "+j);
		if (i < 0 || j < 0 || i >= n || j >= m)
			return false;
		return true;
	}


}
