// { Driver Code Starts
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
                    String str = sc.next();
                 
                    Sol obj = new Sol();
                    System.out.println(obj.maxFrequency(str));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol

{

 int maxFrequency(String S)

	    {	

	        String check = "";

	        int count=0;

	        int n = S.length();

	        

	        for(int i=1;i<n;i++){

	            if(S.substring(0,i).equals(S.substring(n-i)))

	            {

	                check = S.substring(0,i);

	                break;

	            }

	        }

             for(int i=0;i<=n-check.length();i++) 

	        {

	        	if(S.substring(i,check.length()+i).equals(check)) 

	        		count++;

	        }

	   	   return check.length()==0 ? 1:count;

    }

}