// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
             int i = 0,j=n-1;
        while(i<j){
            if(M[i][j]==1){
                i++;
            }
            else{
                j--;
            }
        }
        int cand = i;
        for(int k=0;k<n;k++){
            if(M[cand][k] == 1 && cand!=k){
                return -1;
            }
            if(M[k][cand] == 0 && cand!=k){
                return -1;
            }
        }
        return cand;
    	// code here 
    }
}