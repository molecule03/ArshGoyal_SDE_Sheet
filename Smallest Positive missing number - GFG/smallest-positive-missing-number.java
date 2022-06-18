// { Driver Code Starts
import java.util.*;


 // } Driver Code Ends


class Solution
{
   //Function to find the smallest positive number missing from the array.
   static int missingNumber(int arr[], int n)
   {
       // Your code here
       if(n==1)
       return 1;
       Arrays.sort(arr);
       for(int i=0;i<n-1;i++){
           if(arr[i]<=0&&arr[i+1]>0&&arr[i+1]!=1)
           return 1;
           if(arr[i]>=0&&arr[i+1]-arr[i]>1)
           return arr[i]+1;
       }
       return arr[n-1]+1;
   }
}


// { Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}

  // } Driver Code Ends