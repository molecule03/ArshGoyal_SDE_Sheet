class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
                // List<Integer> list = new ArrayList<>();
        vector<int> list;
        
        int num1 = -1;
        int num2 = -1;
        int c1 = 0;
        int c2 = 0;
        
        for(int i : nums){
            if(i == num1) c1++;
            else if(i == num2) c2++;
            else if(c1 == 0){
                num1 = i;
                c1 = 1;
            }
            else if(c2 == 0){
                num2 = i;
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for(int i : nums){
            if(i == num1){
                c1++;
            }
            else if(i == num2){
                c2++;
            }
        }
        
        if(c1 > nums.size()/3) list.push_back(num1);
        if(c2 > nums.size()/3) list.push_back(num2);
        
        return list;
    }
};