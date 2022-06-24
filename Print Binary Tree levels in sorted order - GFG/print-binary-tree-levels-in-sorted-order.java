// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		ArrayList <ArrayList <Integer>> res = new Solution().binTreeSortedLevels (arr, n);
    		
    		for (int i = 0; i < res.size(); i++)
    		{
    		    for (int j = 0; j < (res.get (i).size()); j++)
    		    {
    		        System.out.print (res.get(i).get(j) + " ");
    		    }
    		    System.out.println ();
    		}
        }
        
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList <ArrayList <Integer>> binTreeSortedLevels (int arr[], int n)
    {
        // your code here       
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int count = 0, i = 0;
        while(count < n){
            ArrayList<Integer> base = new ArrayList<>();
            int items = (int)Math.pow(2,i++);
            while(items-- > 0 && count < n){
                base.add(arr[count++]);
            }
            Collections.sort(base);
            list.add(base);
        }
        return list;
    }
}