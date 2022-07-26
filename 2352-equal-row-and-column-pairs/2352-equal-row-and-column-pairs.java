class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;
        Map<String, Integer> rows = new HashMap<>();
        Map<String, Integer> cols = new HashMap<>();
        
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                sb.append(grid[i][j]+",");
            }
            String s = sb.toString();
            rows.put(s, rows.getOrDefault(s, 0)+1);
        }
        
           
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                sb.append(grid[j][i]+",");
            }
            String s = sb.toString();
            cols.put(s, cols.getOrDefault(s, 0)+1);
        }
        
        // System.out.println(rows+" "+cols);
        
        int count = 0;
        for(String s : rows.keySet()){
            int first = rows.get(s);
            int second = cols.getOrDefault(s, 0);
            count += first*second;
        }
        
        return count;
    }
}