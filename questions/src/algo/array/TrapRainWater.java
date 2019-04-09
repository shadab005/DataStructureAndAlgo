package algo.array;
import java.util.*;

class TrapRainWater {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		int a[]=new int[100];
		while(t-->0){
			int n = in.nextInt();
			for(int i=0;i<n;i++){
				a[i]=in.nextInt();
			}
			calculateWaterTrapped(a,n);
		}
		in.close();*/
		int a[]={100,10,20,80};
		waterCollect(a, a.length);
	}

	public static void calculateWaterTrapped(int[] a, int n) {
		Stack<Integer> s = new Stack<Integer>();
		int total = 0;
		s.push(0);
		for(int i=1;i<n;i++){
			if(a[i]>=a[s.peek()]){
				int last = s.pop();
				while(!s.isEmpty() && a[s.peek()]<=a[i]){
					total+=((Math.min(a[s.peek()],a[i])-a[last])*(i-s.peek()-1));
					last = s.pop();
				}
				if(!s.isEmpty())
					total+=((Math.min(a[s.peek()],a[i])-a[last])*(i-s.peek()-1));
			}
			s.push(i);
		}
		System.out.println(total);
		
	}
	
	static void waterCollect(int a[], int n){
        int result = 0;
        int lMax=0;
        int rMax = 0;
        int s = 0;
        int e = n-1;
        while(s<=e){
            if(a[s]<a[e]){
                if(a[s]>lMax){
                    lMax=a[s];
                }else{
                    result+=lMax-a[s];
                }
                s++;
            }else{
                if(a[e]>rMax){
                    rMax=a[e];
                }else{
                    result+=rMax-a[e];
                }
                e--;
            }
        }
        System.out.println(result);
    }
	
	public int trap(final List<Integer> a) {
		int n = a.size();
		int result = 0;
        int lMax=0;
        int rMax = 0;
        int s = 0;
        int e = n-1;
        while(s<=e){
            if(a.get(s)<a.get(e)){
                if(a.get(s)>lMax){
                    lMax=a.get(s);
                }else{
                    result+=lMax-a.get(s);
                }
                s++;
            }else{
                if(a.get(e)>rMax){
                    rMax=a.get(e);
                }else{
                    result+=rMax-a.get(e);
                }
                e--;
            }
        }
        return result;
    }

}
