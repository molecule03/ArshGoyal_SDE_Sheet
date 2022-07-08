class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int ans = getCost(0, 0, 0, houses, cost, m, n, target);
        
        return ans==Integer.MAX_VALUE/2?-1: ans;
    }
    
    private int getCost (int i, int l, int t, int[] houses, int[][] cost, int m, int n, int target){
        if(t > target) return Integer.MAX_VALUE/2;
        
        if(i == m){
            return t==target ? 0 : Integer.MAX_VALUE/2;
        }
        else if(map.containsKey(""+i+"*"+l+"*"+t)){
            return map.get(""+i+"*"+l+"*"+t);
        }
        else{
            int ans = Integer.MAX_VALUE/2;
            if(houses[i] == 0){
                for(int j=0; j<n; j++){
                ans = Math.min(ans, 
                        cost[i][j]+getCost(i+1, j+1, (l==j+1)?t:t+1, houses, cost, m, n, target ));
                }
            }
            else{
                ans = Math.min(ans, 
                      getCost(i+1, houses[i], (l==houses[i])?t:t+1, houses, cost, m, n,target));
            }
            map.put(""+i+"*"+l+"*"+t, ans);
            return ans;
        }
    }
    
}