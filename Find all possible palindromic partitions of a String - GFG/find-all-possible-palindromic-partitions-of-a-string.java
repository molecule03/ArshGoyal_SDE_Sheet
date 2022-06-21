// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        // code here
        ArrayList<String> al  = new ArrayList<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        solve(0, s, al, res);
        
        return res;
    }
    
    static void solve(int ind, String s, ArrayList<String> al, ArrayList<ArrayList<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList<>(al));
            return;
        }
        
        for(int i=ind; i<s.length(); i++){
            if(isPali(s, ind, i)){
                al.add(s.substring(ind, i+1));
                
                solve(i+1, s, al, res);
                
                al.remove(al.size()-1);
            }
        }
    }
    
    static boolean isPali(String s, int st, int end){
        while(st<=end){
            if(s.charAt(st)!=s.charAt(end)){
                return false;
            }
            
            st++;
            end--;
        }
        return true;
    }
}