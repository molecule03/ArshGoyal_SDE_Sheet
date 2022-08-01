class Solution {
    int memo[][] = new int[201][201];
    int grid[][];
    int m;
    int n;
    int ans = 0;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        if(m == 1 && n == 1) return grid[0][0];
        int op = 0;
        if(m == 1){
            for(int i=0; i<n; i++){
                 op += grid[0][i];
            }
            
            return op;
        }
        if(n == 1){
            for(int i=0; i<n; i++){
                op += grid[i][0];
            }
            
            return op;
        }
        
        this.grid = grid;
        
        
        int res = grid[0][0] + Math.min(find(1,0), find(0,1));
        
        return res;
    }
    
    private int find(int i, int j){
        if(i == m-1 && j == n-1) return grid[i][j];
        
        if(memo[i][j] != 0) return memo[i][j];
        if(i == m-1){
            ans = grid[i][j] + find(i, j+1);
        }
        else if(j == n-1){
            ans = grid[i][j] + find(i+1, j);
        }
        else{
            ans = grid[i][j] + Math.min(find(i+1, j), find(i, j+1));
        }
        
        memo[i][j] = ans;
        return ans;
    }
}