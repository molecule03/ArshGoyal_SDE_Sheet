// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.findLeastGreater(n, arr);
            
            IntArray.print(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
     

public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
       // code here
       ArrayList<Integer> res=new ArrayList();
       TreeMap<Integer,Integer> trs=new TreeMap();
       Arrays.stream(arr).forEach(e->trs.put(e,trs.getOrDefault(e,0)+1));
       for(int i:arr)
       {
           int ge=i;
           int get=trs.get(i);
           trs.remove(ge);
           Integer t=trs.ceilingKey(ge);
           if(t==null)
           res.add(-1);
           else
           res.add(t);
           if(get>1)
           trs.put(ge,get-1);
       }
       return res;
   }
}
        
