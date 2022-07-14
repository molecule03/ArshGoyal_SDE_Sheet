// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_StrongNumber(n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_StrongNumber(int n)
    {
        // Code here
        int res = check_strong(n);
        if(res == n){
            return 1;
        }
        
        return 0;
    }
    
    private int check_strong(int n){
        
        int sum = 0;
        while(n != 0){
            int t = n%10;
            n = n/10;
            int s = 1;
            for(int i=2; i<=t; i++){
                s = s*i;
            }
            sum += s;
        }
        
        return sum;
    }
}