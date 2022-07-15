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
            String s = sc.next ();
            int n = sc.nextInt();

    		System.out.println (new Sol().getCount (s, n)); 
        }
        
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Sol
{
    int getCount (String s, int N)
    {
        // your code here
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) != s.charAt(i)){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            }
        }
        
        int count = 0;
        for(char c : map.keySet()){
            if(map.get(c) == N)
            count++;
        }
        
        return count;
    }
}