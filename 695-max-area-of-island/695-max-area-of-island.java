class Solution {
    
    boolean[][] visited = new boolean[50][50];
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<m; i++){
            // int area = 0;
            for(int j=0; j<n; j++){    
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea,getArea(i, j, grid));
                } 
            }
        }
        
        
        return maxArea;
    }
    
    private int getArea(int i, int j, int[][]grid){
        
    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || visited[i][j])
        return 0;
        
        visited[i][j] = true;
        
        return 1+(getArea(i+1, j, grid)+
                  getArea(i-1, j, grid)+
                  getArea(i, j+1, grid)+
                  getArea(i, j-1, grid)
                 );
    }
}