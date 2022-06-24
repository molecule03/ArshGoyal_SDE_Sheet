// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
   void solve(int n,int one,int zero,String op,ArrayList<String> res)
   {
       if(n==0)
       {
           res.add(op);
           return;
       }
       String op1 = op;
       op1 = op1+'1';
       solve(n-1,one+1,zero,op1,res);
       
       if(one>zero)
       {
           String op2= op;
           op2= op2+'0';
           solve(n-1,one,zero+1,op2,res);
       }
       return;
   }
   ArrayList<String> NBitBinary(int N) {
       ArrayList<String> res = new ArrayList<>();
      int n =N;
      int one = 0;
      int zero =0;
      String op = "";
      solve(n,one,zero,op,res);
      return res;
      
   }
}