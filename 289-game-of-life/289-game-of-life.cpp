class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int dx[] = {0, 0, 1, 1, 1,-1,-1,-1};
        int dy[] = {1,-1, 0, 1,-1, 0, 1,-1};
        
        for(int r=0; r<board.size(); r++){
            for(int c=0; c<board[0].size(); c++){
                
                int curLiv = 0;
                for(int i=0; i<8; i++){
                    int x = r+dx[i];
                    int y = c+dy[i];
                    
                    if(isValid(x, y, board) && abs(board[x][y]) == 1)
                        curLiv++;
                }
                
                // System.out.println("r="+r+" "+"c="+c+" "+curLiv);
                if(board[r][c] == 1 && (3 < curLiv || curLiv < 2))
                    board[r][c] = -1;
                else if(board[r][c] == 0 && curLiv == 3)
                    board[r][c] = 2;
            }
        }
        
        for(int r=0; r<board.size(); r++){
            for(int c=0; c<board[0].size(); c++){
                if(board[r][c] >=1)
                    board[r][c] = 1;
                else if(board[r][c]<=0)
                    board[r][c] = 0;
            }
        }
    }
    
    bool isValid(int x, int y, vector<vector<int>>& board){
        
        if(x<0 || x>=board.size() || y<0 || y>=board[0].size())
            return false;
        
        return true;
    }

};