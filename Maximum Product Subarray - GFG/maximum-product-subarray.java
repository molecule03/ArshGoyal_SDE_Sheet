// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
   // Function to find maximum product subarray
   long maxProduct(int[] arr, int n) {
       // code here
      long currentMax = 1,currentMin = 1,result = Integer.MIN_VALUE;

       for(int i=0;i<arr.length;i++) {
            currentMax *= arr[i];
            currentMin *= arr[i];
           long tempMax = Math.max(arr[i],Math.max(currentMax,currentMin));
           currentMin = Math.min(arr[i],Math.min(currentMax,currentMin));
           currentMax = tempMax;

           result = Math.max(result,currentMax);
       }

       return result;
   }
}