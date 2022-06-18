// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int r = Integer.parseInt(inputLine[0]);
            int c = Integer.parseInt(inputLine[1]);
            boolean[][] mat = new boolean[r][c];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = (Integer.parseInt(inputLine[i * c + j]) == 1);
                }
            }

            int ans = new Solution().maxArea(mat, r, c);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    int maxArea(boolean[][] mat, int r, int c) {
        
        int bar[][] = new int[r][c];
        
        for(int i=0; i<r ; i++ ){
            
            for(int j=0;j<c;j++){
                
                bar[i][j] = (mat[i][j]== true)? 1:0;
                
                if( i > 0){
                    if(bar[i][j] != 0 ){
                        bar[i][j] += bar[i-1][j];
                    }
                }
            }
        }
        
        
        int ans = 0;
        for(int []a:bar){
            
            ans = Math.max(ans , getMaxArea(a , c) );
        }
        
        
        
        
        return ans;
    }
    
    int getMaxArea( int []a , int n ){
        // since we can swap any columns
        Arrays.sort(a);
        int ans = 0;
        for(int i=0; i< n ; i++ ){
            
            ans= Math.max(ans , (a[i] * (n-i))  );
        }    
        
        return ans;
    }
}