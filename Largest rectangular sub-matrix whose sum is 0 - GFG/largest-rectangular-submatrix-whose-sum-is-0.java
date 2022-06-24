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


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] nm = IntArray.input(br, 2);
            
            
            int[][] a = IntMatrix.input(br, nm[0], nm[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.sumZeroMatrix(a);
            
            if(res.size() == 0) {
                System.out.println(-1);
                
            } else {
            
                IntMatrix.print(res);
            }        
        }
    }
}
// } Driver Code Ends


class Solution {
    
    private static int[] maxLen(int[] arr)
    {
        int ans[] =  new int[2];
        int n = arr.length;
        int endingIdx = -1;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int sum = 0,maxlen = 0;
        for(int i = 0;i<n;i++){
            sum+=arr[i];
            if(mp.containsKey(sum)==true){
                if(maxlen<(i-mp.get(sum))){
                   endingIdx = i;
                   maxlen = i-mp.get(sum);
                }
                
            }else{
                mp.put(sum,i);
            }
        }
        ans[0] = maxlen;
        ans[1] = endingIdx;
        return ans;
    }
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        int N = a.length;
        int M = a[0].length;
        int finalmaxA = 0;
        int starting_row = 0;
        int ending_row = 0;
        int starting_col = 0;
        int ending_col = 0;
        for(int i = 0;i<N;i++){
            int[] arr = new int[M];
            for(int j = i;j<N;j++){
                for(int k = 0;k<M;k++){
                    arr[k] += a[j][k];
                   // System.out.print(arr[k]+" ");
                }
               // System.out.println();
                int[] pair = maxLen(arr);
                if(pair[0]*(j-i+1)>finalmaxA || pair[0]*(j-i+1)>=finalmaxA && pair[0]-1>(ending_col-starting_col) ){
                    finalmaxA = pair[0]*(j-i+1);
                    starting_row = i;
                    ending_row = j;
                    starting_col = pair[1]-pair[0]+1;
                    ending_col = pair[1];
                }
            }
        }
        //System.out.println(starting_row+" "+ending_row+" "+starting_col+" "+ending_col);
       ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();
       if(starting_row==0 && ending_row ==0 && starting_col == 0 && ending_col == 0 ) return ans;
       for(int i = starting_row;i<=ending_row;i++){
           ArrayList<Integer> tmp = new ArrayList<>();
           for(int j = starting_col;j<=ending_col;j++){
               tmp.add(a[i][j]);
           }
           ans.add(new ArrayList<>(tmp));
       }
       return ans;
    }
}
        
