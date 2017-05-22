import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class SameSnake {

	public static void main(String[] args) {
		int x1[]= new int[2];//{2,8};
		int y1[]=new int[2];//{1,1};
		
		int x2[]=new int[2];//{11,7};
		int y2[]=new int[2];//{1,1};
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		
		for(int i = 0; i<t;i++){
			x1[0]=in.nextInt();
			y1[0]=in.nextInt();
			x1[1]=in.nextInt();
			y1[1]=in.nextInt();
			
			x2[0]=in.nextInt();
			y2[0]=in.nextInt();
			x2[1]=in.nextInt();
			y2[1]=in.nextInt();
			
			int a[],b[];
			if(y1[0]==y2[0] && y1[1]==y2[1]){//Snake is along x axis
				a=x1;
				b=x2;
				
				int min = Math.min(a[0],a[1]);
				int max = Math.max(a[0], a[1]);
				if((min<b[0] && min <b[1] && max<b[0] && max <b[1])||(min>b[0] && min >b[1] && max>b[0] && max > b[1])){
					System.out.println("no");
				}else{
					System.out.println("yes");
				}
				
			}else if(x1[0]==x2[0] && x1[1]==x2[1]){//Snake is along x axis
				a=y1;
				b=y2;
				
				int min = Math.min(a[0],a[1]);
				int max = Math.max(a[0], a[1]);
				if((min<b[0] && min <b[1] && max<b[0] && max <b[1])||(min>b[0] && min >b[1] && max>b[0] && max > b[1])){
					System.out.println("no");
				}else{
					System.out.println("yes");
				}
			}else{ //one snake is along x axis and one is along y-axis
				if((x1[0]==x2[0] && y1[0]==y2[0])|| (x1[0]==x2[1] && y1[0]==y2[1]) ||
						(x1[1]==x2[0] && y1[1]==y2[0]) || (x1[1]==x2[1] && y1[1]==y2[1])){
					System.out.println("yes");
				}else{
					System.out.println("no");
				}
			}
			
		}
		in.close();
	}

}
