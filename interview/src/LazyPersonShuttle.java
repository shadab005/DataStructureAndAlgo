
public class LazyPersonShuttle {

	public static void main(String[] args) {
		//int a[] = {5,7,12,13,21,22,23,25,28,29,35,40,41,44,48,60};
		//int a[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		//int a[] = {3,5,10,12,14,45};
		int a[] = {1,1,1,1};
		System.out.println(solve(a, 10, 2, 7));
	}
	
	static int solve(int a[], int slotSize, int capacity, int numOfSlot) {
		int lastSlot = slotSize*(numOfSlot-1);
		int nextSlot = 0;
		int i = 0;
		int j = 0;
		while(i < a.length) {
			j = i;
			while(j < a.length && a[j] <= nextSlot) {
				j++;
			}
			if(j == a.length) break;
			int totalPending = j - i + 1;
			if(totalPending > capacity) {
				i = i+capacity;
			} else if(i!=j){
				i = j+1;
			}
			nextSlot = nextSlot+slotSize;
			if(nextSlot>lastSlot)break;
		}
		
		int totalPending = j - i + 1;
		int remaining = ((lastSlot-nextSlot)/slotSize)*capacity;
		if(totalPending<remaining)return lastSlot;
		i = Math.min(i+capacity, a.length);
		return a[i-1];
	}

}
