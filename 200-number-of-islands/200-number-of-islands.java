class Solution {
    char grid[][];
    boolean visited[][];
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        this.grid = grid;
        visited = new boolean[m][n];
        
        int countOfIsland = 0;
        for(int i=0; i<m; i++){
            // int area = 0;
            for(int j=0; j<n; j++){    
                if(grid[i][j] == '1' && !visited[i][j]){
                    getArea(i, j);
                    countOfIsland++;
                } 
            }
        }
        
        return countOfIsland;
    }
    
    private void getArea(int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || 
           grid[i][j]=='0' || visited[i][j] )
        return;
        
        visited[i][j] = true;
        
        getArea(i+1, j);
        getArea(i-1, j); 
        getArea(i, j+1); 
        getArea(i, j-1); 
          
        return;
    }
}