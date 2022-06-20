class Solution {
public:
    bool canJump(vector<int>& nums) {
                
        int goodInd = nums.size()-1;
        
        for(int i=nums.size()-1; i>=0; i--){
            if(i+nums[i] >= goodInd){
                goodInd = i;
            }
        }
        
        if(goodInd == 0) return true;
        
        
        return false;
    }
};