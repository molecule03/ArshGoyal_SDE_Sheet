class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> b-a);
        
        for(int i : nums){
            heap.offer(i);
        }
        
        int ans = 0;
        while(k > 0){
            ans = heap.poll();
            k--;
        }
        
        return ans;
    }
}