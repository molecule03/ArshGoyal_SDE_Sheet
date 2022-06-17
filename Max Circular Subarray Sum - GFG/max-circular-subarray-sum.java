// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
     static int normalSum(int arr[], int num) {
         int res=arr[0], maxEnding=arr[0];
          for(int i=1; i<num; i++) {
               maxEnding=Math.max(arr[i], maxEnding+arr[i]);
               res=Math.max(res,maxEnding);
          }
          return res;
    }
   static int circularSubarraySum(int arr[], int num) {
       
       int max_normal=normalSum(arr,num);
           if(max_normal<0) {
               return max_normal;
           }
             int arr_sum=0;
              for(int i=0; i<num; i++) {
                  arr_sum+=arr[i];
                   arr[i]=-arr[i];
              }
               int max_circular= arr_sum+normalSum(arr,num);
                return Math.max(max_normal, max_circular);
}
}

