
public class DPMinSumPathMatrix {

	public int minPathSum(int[][] a) {
        int m  = a.length;
		int n  = a[0].length;
		
		for(int i = 1 ;i < m ;i++)a[i][0]=a[i][0]+a[i-1][0];
		for(int j = 1 ;j < n ;j++)a[0][j]=a[0][j]+a[0][j-1];
		for(int i=1;i<m;i++){
		    for(int j=1;j<n;j++){
		        a[i][j] = a[i][j]+Math.min(a[i-1][j],a[i][j-1]);
		    }
		}
		//Util.printArray(a);
       return a[m-1][n-1];
    }
	
	public static void main(String[] args) {
		DPMinSumPathMatrix d = new DPMinSumPathMatrix();
		int a[][]= {
				{1, 3, 2},
				{4, 3, 1},
				{5, 6, 1}
		};
		System.out.println(d.minPathSum(a));
				

	}

}
