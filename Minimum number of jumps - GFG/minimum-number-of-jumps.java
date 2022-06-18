// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        return minJumps(arr,arr.length);
    }
    static int minJumps(int arr[], int n){
       int jumps = 0, maxi = 0, cur = 0;
       for(int i=0; i<n-1; i++) {
           maxi = Math.max(maxi, arr[i] + i);
           if(i == cur) {
               cur = maxi; 
               jumps++;
           }
       }
       if(cur < n-1) {
           return -1;
       }
       return jumps;
   }
}