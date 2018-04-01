package algo.greedy;

public class PetrolPump {
	
     public static int canCompleteCircuit(final int[] gas, final int[] cost) {
        int n = gas.length; 
        int fuel = 0;
        int start = 0;
        int prev = -1;
        int i=0;
        int touchCount = 0;
        while(touchCount <= n+1) {
        	//System.out.println("Hello");
        	touchCount++;
        	fuel=fuel+gas[i]-cost[i];
        	if(fuel<0) {
        		if(prev>=i+1)return -1;
        		prev = start;
        		start = i+1;
        		fuel = 0;
        		touchCount = 0;
        		if(start>=n)return -1;
        	}
        	i = (i+1)%n;
        }
      return start;   
    }
     
     public static int canComplete(final int[] gas, final int[] cost) {
    	 int sumGas = 0;
         int sumCost = 0;
         int start = 0;
         int tank = 0;
         for (int i = 0; i < gas.length; i++) {
             sumGas += gas[i];
             sumCost += cost[i];
             tank += gas[i] - cost[i];
             if (tank < 0) {
                 start = i + 1;
                 tank = 0;
             }
         }
         if (sumGas < sumCost) {
             return -1;
         } else {
             return start;
         }
     }

	public static void main(String args[]) {
		int[] gas = {6,3,7};
		int[] cost = {4,16,3};
		System.out.println(canComplete(gas, cost));
	}

}
