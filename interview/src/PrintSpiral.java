import java.util.Scanner;

/*
 * OYO
 */
public class PrintSpiral {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-->0) {
		    int n = in.nextInt();
		    char[][] a = new char[n][n];
		    for(int i=0;i<n;i++) {
		    	for(int j=0;j<n;j++) {
		    		a[i][j] = in.next().charAt(0);
		    	}
		    }
		    //print(a,n);
		    //System.out.println("Solving.....\n");
		    printSpiral(a,n);
		    System.out.println();
		}
		in.close();

	}
	/*
	 * 
2
5
i l o v e
s q u e s
o n s s o
y o i t l
o g n i v
2
a b
c d

	 */
	
	private static void printSpiralII(char[][] a) {
		int m = a.length;
		int n = a[0].length;
		int xStepCount = n-1;
		int yStepCount = m-1;
		int i = 0,j=0;
		while(xStepCount>=0) {
			//System.out.println("xCount="+xStepCount+" yCount="+yStepCount);
			printHorizontalForward(a,i,j, xStepCount);
			j = j+xStepCount;
			
			printVerticalDownward(a,i,j,yStepCount);
			i=i+yStepCount;
			
			printHorizontalBackward(a,i,j, xStepCount);
			j=j-xStepCount;
			
			yStepCount--;
			printVerticalUpward(a,i,j, yStepCount);
			i=i-yStepCount;
			
			j=j+1;
			xStepCount--;
			xStepCount--;
			yStepCount--;
			
		}
		
	}


	private static void printSpiral(char[][] a, int n) {
		int xStepCount = n-1;
		int yStepCount = n-1;
		int i = 0,j=0;
		while(xStepCount>=0) {
			//System.out.println("xCount="+xStepCount+" yCount="+yStepCount);
			printHorizontalForward(a,i,j, xStepCount);
			j = j+xStepCount;
			
			printVerticalDownward(a,i,j,yStepCount);
			i=i+yStepCount;
			
			printHorizontalBackward(a,i,j, xStepCount);
			j=j-xStepCount;
			
			yStepCount--;
			printVerticalUpward(a,i,j, yStepCount);
			i=i-yStepCount;
			
			j=j+1;
			xStepCount--;
			xStepCount--;
			yStepCount--;
			
		}
		
	}

	private static void printHorizontalForward(char[][] a, int i, int j, int xStepCount) {
		System.out.print(a[i][j]);
		j++;
		while(xStepCount>0) {
			System.out.print(a[i][j]);
			xStepCount--;
			j++;
		}
		//System.out.println();
	}
	
	private static void printHorizontalBackward(char[][] a, int i, int j, int xStepCount) {
		//System.out.print(a[i][j]);
		j--;
		while(xStepCount>0) {
			System.out.print(a[i][j]);
			xStepCount--;
			j--;
		}
		//System.out.println();
		
	}

	private static void printVerticalUpward(char[][] a, int i, int j, int yStepCount) {
		//System.out.print(a[i][j]);
		i--;
		while(yStepCount>0) {
			System.out.print(a[i][j]);
			yStepCount--;
			i--;
		}
		//System.out.println();
		
	}

	private static void printVerticalDownward(char[][] a, int i, int j, int yStepCount) {
		//System.out.print(a[i][j]);
		i++;
		while(yStepCount>0) {
			System.out.print(a[i][j]);
			yStepCount--;
			i++;
		}
		//System.out.println();
	}

	

	private static void print(char[][] a, int n) {
		for(int i=0;i<n;i++) {
	    	for(int j=0;j<n;j++) {
	    		System.out.print(a[i][j]+ " ");
	    	}
	    	System.out.println();
		}
		
	}

}
