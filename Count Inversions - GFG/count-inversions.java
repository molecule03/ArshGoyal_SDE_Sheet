// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    static long merge(long arr[],long temp[],long left,long mid,long right){
       long i,j,k,inv=0;
        i=left;j=mid;k=left;
        while((i<=mid-1) && (j<=right)){
            if(arr[(int)i]<=arr[(int)j]){
                temp[(int)k++]=arr[(int)i++];
            }
            else{
                temp[(int)k++]=arr[(int)j++];
                inv+=(mid-i);
            }
        }
        while(i<=mid-1){
            temp[(int)k++]=arr[(int)i++];
        }
        while(j<=right){
            temp[(int)k++]=arr[(int)j++];
        }
        for(i=(int)left;i<=right;i++){
            arr[(int)i]=temp[(int)i];
        }
        return inv;
        
    }
    static long mergeSort(long arr[],long temp[],long left,long right){
        long mid=0, inv=0;
        if(right>left){
            mid=(left+right)/2;
            inv+=mergeSort(arr,temp,left,mid);
            inv+=mergeSort(arr,temp,mid+1,right);
            inv+=merge(arr,temp,left,mid+1,right);
        }
        return inv;
    }
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long ans=mergeSort(arr,new long[(int)N],0,N-1);
        return ans;
    }
}