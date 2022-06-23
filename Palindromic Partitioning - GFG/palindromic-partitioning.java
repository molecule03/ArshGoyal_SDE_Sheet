// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(String str,int start,int end, int[][] dp){
        if(dp[start][end]!=-1) return dp[start][end];
        if(start==end) return 0;
        if(isPali(str,start,end)) {
            return 0;
        }
        int min = solve(str,start+1,end,dp)+1;
        for(int i =start+1;i<=end;i++){
            if(isPali(str,start,i)){
                min = Math.min(min,solve(str,i+1,end,dp)+1);
            }
        }
        dp[start][end] = min;
        return min;
    }
    static boolean isPali(String str,int i,int j){
        int start = i,end = j;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    static int palindromicPartition(String str)
    {
        int n = str.length();
        int[][] dp = new int[n][n];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        int ans = solve(str,0,n-1,dp);
        
        return ans;
    }
}