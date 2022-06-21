class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        
        
        int i = m-1;
        int j = n-1;
        int k = nums1.length-1;
        
        while(i >= 0 && j>=0){
                    // System.out.println("In Upper Loop");
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        
        while(j >= 0){
            // System.out.println("In Lower Loop");
            nums1[k--] = nums2[j--];
        }
        
    }
}