// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
   static int majorityElement(int nums[], int size)
   {
       // your code here
       int count = 0;
       Integer candidate = null;

       for (int num : nums) {
           if (count == 0) {
               candidate = num;
           }
           count += (num == candidate) ? 1 : -1;
       }
       
       int check = 0;
       for(int num : nums){
           if(num == candidate) check++;
       }
       
       if(check > size/2){
         return candidate;
       }
       else return -1;
   }
}