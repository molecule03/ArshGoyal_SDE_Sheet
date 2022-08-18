class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> res (n-2, vector<int>(n-2));
        
        int m = 0;
        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                m=0;
                for(int x=i; x<=i+2; x++){
                    for(int y=j; y<=j+2; y++){
                        m = max(grid[x][y], m);
                    }
                }
                res[i][j] = m;
            }
        }
        
        return res;
    }
};