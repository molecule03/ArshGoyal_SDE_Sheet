class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        
        Queue<int[]> heap = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        int maxRes = nums[0];
        heap.offer(new int[]{nums[0],0});
        
        for(int i=1; i<n; i++){
            while(i-heap.peek()[1] > k) heap.poll();
            
            maxRes = nums[i]+heap.peek()[0];
            heap.offer(new int[]{maxRes, i});
        }
        
        return maxRes;
    }
}