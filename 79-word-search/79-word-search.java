class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        
        int r = board.length;
        int c = board[0].length;
        
        visited = new boolean[r][c];
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(word.charAt(0)==board[i][j] && search(i, j, 0, board, word)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(int i, int j, int idx, char[][] board, String word){
        if(idx == word.length()){
            return true;
        }
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(idx) != board[i][j] || visited[i][j]){
            // System.out.println("Boundary wale false");
            return false;
        }
        
        visited[i][j] = true;
        if(search(i+1, j, idx+1, board, word) ||
           search(i-1, j, idx+1, board, word) ||
           search(i, j+1, idx+1, board, word) ||
           search(i, j-1, idx+1, board, word) 
          )
            return true;
        
        
            visited[i][j] = false;
        
        return false;
    }
}