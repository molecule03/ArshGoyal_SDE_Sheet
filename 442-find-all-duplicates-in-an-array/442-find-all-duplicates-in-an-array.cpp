class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> list; // = new ArrayList<>();
        
        for(int i=0; i<nums.size(); i++){
// Only take positive Integers
            int n = abs(nums[i]);
            
// If num[1] is already negative then then add n i.e 2 to the list as duplicate
            if(nums[n-1] < 0)
                list.push_back(abs(n));
        
// Mark n-1th idx as -ve
            nums[n-1] = -nums[n-1]; // if n=2 do nums[1] = -nums[1] to mark that 2 has been visited 
        }
        
        return list; 
    }
};