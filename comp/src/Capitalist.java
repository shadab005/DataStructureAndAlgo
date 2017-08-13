import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Capitalist {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int max=-1;
		int m=0,n=0;
		int a[][] = new int[501][501];
		int temp[][] = new int[501][501];
		while(t-->0){
			n = in.nextInt();
			m = in.nextInt();
			max = -1;
			for(int i =0 ;i <n ; i++){
				for(int j=0;j<m;j++){
                   a[i][j]=in.nextInt();
                   max = Math.max(max, a[i][j]);
                   temp[i][j] = Integer.MAX_VALUE;
				}
			}
			findMin(a,n,m,temp,max);
		}
		in.close();
	}

	public static void findMin(int[][] a, int n, int m,int[][] temp, int max) {
		for(int i = 0; i<n;i++){
			for(int j=0;j<m;j++){
			   	if(a[i][j]==max){
			   		calculateStepsToJumpToNeighbours(temp, i , j , 0, n, m);
			   	}
			}
		}
		int ans=-1;
		for(int i = 0; i<n;i++){
			for(int j=0;j<m;j++){
			   	if(temp[i][j]>ans)ans=temp[i][j];
			}
		}
		System.out.println(ans);
	}

	public static void calculateStepsToJumpToNeighbours(int[][] temp, int i, int j, int k, int n, int m) {
		if(i<0 || j<0 || i>=n || j>=m)return;
		if(temp[i][j]<k)return;
		temp[i][j]=k;
		
		calculateStepsToJumpToNeighbours(temp,i-1,j-1,k+1,n,m);
		calculateStepsToJumpToNeighbours(temp,i-1,j,k+1,n,m);
		calculateStepsToJumpToNeighbours(temp,i-1,j+1,k+1,n,m);
		
		calculateStepsToJumpToNeighbours(temp,i,j-1,k+1,n,m);
		calculateStepsToJumpToNeighbours(temp,i,j+1,k+1,n,m);
		
		calculateStepsToJumpToNeighbours(temp,i+1,j-1,k+1,n,m);
		calculateStepsToJumpToNeighbours(temp,i+1,j,k+1,n,m);
		calculateStepsToJumpToNeighbours(temp,i+1,j+1,k+1,n,m);
		
	}
	
/*	int dx[] = {1, 1, 1, -1, -1, -1, 0, 0}, dy[] = {1, 0, -1, 1, 0, -1, 1, -1};
	for(int i = 0; i < 8; i++){
        if(valid(x + dx[i], y + dy[i]) == 1 and visited[x + dx[i]][y + dy[i]] == 0){
            Q.push({{x + dx[i], y + dy[i]}, d + 1});
            visited[x + dx[i]][y + dy[i]] = 1;
        }
    }*/

}
