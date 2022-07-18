class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int res = 0;
        int curMat[] = new int[n];
        for(int i=0; i<m; i++){
            Arrays.fill(curMat, 0);
            for(int j=i; j<m; j++){
                for(int k=0; k<n; k++){
                    curMat[k] += matrix[j][k];
                }
                res += subarray(curMat, target);
            }
        }
        
        return res;
    }
    
    
    private int subarray(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        return count;
    }
}