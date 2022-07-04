class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
            PriorityQueue<Pair<Integer, Integer>> pq = 
        new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        
        int maxVal = Integer.MIN_VALUE;
        for(int point[] : points){
            
            while(!pq.isEmpty() && point[0]-pq.peek().getValue() > k )
                pq.poll();
            
            if(!pq.isEmpty()){
                maxVal = Math.max(maxVal, point[0]+point[1]+pq.peek().getKey());
            }
            
            pq.offer(new Pair<>(point[1]-point[0], point[0]));
        }
        
        return maxVal;
    }
}