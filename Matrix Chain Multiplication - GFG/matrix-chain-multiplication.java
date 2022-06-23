// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][] = new int[N][N];
        for(int g=1;g<N-1;g++) {
            for(int i=0,j=g;j<N-1;i++,j++) {
                if(g==1) {
                    dp[i][j] = arr[i]*arr[i+1]*arr[i+2];
                }
                else {
                    int min = Integer.MAX_VALUE;
                    int index = j;
                    for(int k=j-1;k>=i;k--) {
                        int val = arr[i]*arr[k+1]*arr[j+1];
                        val += dp[i][k] + dp[index--][j];
                        min = Math.min(min,val);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][N-2];
    }
}