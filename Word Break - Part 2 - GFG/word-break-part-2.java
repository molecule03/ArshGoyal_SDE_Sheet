// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> wordBreak(int n, List<String> B, String A)
    {
        // code here
           List<String> ans = new ArrayList<>();
      helper(n,B,A,ans,"");
      return ans;
   }    
   
   public static void helper(int n, List<String> B, String A, List<String> ans,String str)
   {
       if(A.length()==0)
       {
           //System.out.println(str);
           str=str.trim();
           ans.add(str);
           return;
       }
       
      for(int x=1;x<=A.length();x++)
      {
          String newstr = A.substring(0,x);
          
          if(B.contains(newstr))
          {
              //System.out.println(newstr);
              helper(n,B,A.substring(x,A.length()),ans,str+newstr+" ");
          }
      }
    }
}