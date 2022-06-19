class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        
        int sum =0;
        for(int i=0; i<nums.size(); i++){
            sum += nums[i];
        }
        
        // cout<<sum;
        
        int left = 0;
        int right = sum-nums[0];
        if(left == right) return 0;
        
        int idx = -1;
        for(int i=1; i<nums.size(); i++){
            // cout<<left<<" "<<right<<endl;
            left += nums[i-1];
            right -= nums[i];
            
            if(left == right)
                return i;
        }      
        
        
        
        return -1;
    }
};