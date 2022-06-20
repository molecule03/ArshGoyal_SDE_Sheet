class Solution {
    public List<Integer> spiralOrder(int[][] mat) {

        int r = mat.length;
        int c = mat[0].length;
        
        boolean[][] isVis = new boolean[r][c];
        List<Integer> list = new ArrayList<>();
        
        int colB = 0;
        int colE = c-1;
        int rowB = 0;
        int rowE = r-1;
        while(colB<=colE && rowB<=rowE){
            for(int i=colB; i<=colE; i++){
                if(!isVis[rowB][i]){
                    list.add(mat[rowB][i]);
                    isVis[rowB][i] = true;
                }
            }
            rowB++;
            
            for(int i=rowB; i<=rowE; i++){
                 if(!isVis[i][colE]){
                    list.add(mat[i][colE]);
                    isVis[i][colE] = true;
                }
            }
            colE--;

            for(int i=colE; i>=colB; i--){
                 if(!isVis[rowE][i]){
                    list.add(mat[rowE][i]);
                    isVis[rowE][i] = true;
                }
            }
            rowE--;
            for(int i=rowE; i>=rowB; i--){
                 if(!isVis[i][colB]){
                    list.add(mat[i][colB]);
                    isVis[i][colB] = true;
                }
            }
            colB++;
        }
        return list;
    }
}