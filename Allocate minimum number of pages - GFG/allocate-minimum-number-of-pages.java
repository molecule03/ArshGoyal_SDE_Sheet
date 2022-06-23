// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
   //Function to find minimum number of pages.
   public static int findPages(int[]A,int N,int M)
   {
       int lb=0;
       int s=0;
       int ans=0;
       for(int i=0;i<N;i++) s+=A[i];
       int ub=s;
       while(lb<=ub){
           int mid=(lb+ub)/2;
           if(solve(A,N,mid,M)){
               ans=mid;
               ub=mid-1;
           }else{
               lb=mid+1;
           }
       }
       return ans;
   }
   static boolean solve(int arr[],int n,int mid, int m){
       int sum=0;
       int stu=1;
       for(int i=0;i<n;i++){
           if(arr[i]>mid) return false;
           if(arr[i]+sum>mid){
               stu++;
               sum=arr[i];
               if(stu>m)  return false;
           }
           else sum+=arr[i];
       }
       return true;
   }
};