// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

public int minDifference(int arr[], int n) 
{ 
    // Your code goes here
    int target=0;
    for(int i=0;i<n;i++)
    {
        target+=arr[i];
    }
    boolean t[][]=new boolean[n+1][target+1];
    for(int i=0;i<=n;i++)
    {
        for(int j=0;j<=target;j++)
        {
            t[i][j]=false;
        }
    }
    for(int i=0;i<=n;i++)
    {
        t[i][0]=true;
    }
    
    for(int i=1;i<n+1;i++)
    {
        for(int j=1;j<target+1;j++)
        {
            if(arr[i-1]<=j)
            {
                t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j];
            }
            else
            {
                t[i][j]=t[i-1][j];
            }
        }
    }
    ArrayList<Integer> li=new ArrayList<>();
    int ntarget=(target+1)/2;
    for(int i=0;i<ntarget+1;i++)
    {
        if(t[n][i]==true)
        {
            li.add(i);
        }
    }
    int mini=(int)Math.pow(10,8);
    for(int i=0;i<li.size();i++)
    {
        mini=Math.min(mini,Math.abs((target-2*li.get(i))));
    }
    return mini;
    
} 
}
