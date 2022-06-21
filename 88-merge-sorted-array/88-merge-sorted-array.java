class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<m; i++){
            pq.add(nums1[i]);
        }
        
        for(int j=0; j<n; j++){
            pq.add(nums2[j]);
        }
        
        // System.out.println(pq);
        for(int i=0; i<nums1.length; i++){
            nums1[i] = pq.poll();
        }
    }
}