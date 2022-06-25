// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}


// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        int i = 0;
        int j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxTrain = 0;
        int plateform = 0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                maxTrain++;
                i++;
            }
            else{
                maxTrain--;
                j++;
            }
            plateform = Math.max(plateform,maxTrain);
        }
        return plateform;
    }
}

