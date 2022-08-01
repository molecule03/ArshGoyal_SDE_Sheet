class Solution {
    
    int memo[][] = new int[101][101];
    int m;
    int n;
    
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        
        int ans = paths(0, 0);
        
        return ans;
    }
    
    public int paths(int right, int down){
        if(right == n-1 && down == m-1) return 1;
        
        if(memo[right][down] != 0) return memo[right][down];
        
        int ans=0;
        if(right == n-1){
            ans = paths(right, down+1);
        }
        else if(down == m-1){
            ans = paths(right+1, down);
        }
        else{
            ans = paths(right+1, down) + paths(right, down+1);
        }
        
        memo[right][down] = ans;
        return ans;
    }
}