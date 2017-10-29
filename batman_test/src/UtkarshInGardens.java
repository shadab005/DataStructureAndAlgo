import java.util.ArrayList;
import java.util.Scanner;
 
public class UtkarshInGardens{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res=0;
        int arr[][] = new int[n][n];
        ArrayList<Integer> adjList[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int z = sc.nextInt();
                if(z==1){
                    adjList[i].add(j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = 0;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<adjList[i].size();j++){
                for(int k=j+1;k<adjList[i].size();k++){
                    arr[adjList[i].get(j)][adjList[i].get(k)]++;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res += arr[i][j]*(arr[i][j] - 1);
            }
        }
        System.out.println(res/4);
        
       
        
        
    }
}	