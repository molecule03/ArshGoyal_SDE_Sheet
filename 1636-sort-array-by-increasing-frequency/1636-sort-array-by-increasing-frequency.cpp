class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
       
        unordered_map<int,int>mp;
        for(auto it:nums){
            mp[it]++;
        }
        vector<vector<int>> temp;
        for(auto i : mp){
            vector<int> arr(2);
            arr[0] = i.first;
            arr[1] = i.second;
            temp.push_back(arr);
        }
        sort(temp.begin(),temp.end(), sortele);
        
        // for(auto arr : temp){
        //     cout<<arr[0]<<"->"<<arr[1]<<" ";
        // }
        vector<int> ans;
        for(auto v : temp){
            for(int i=0; i<v[1]; i++){
                ans.push_back(v[0]);
            }
        }
        
        
        return ans;
    }
    
   static bool sortele(vector<int> a, vector<int> b){
       if(a[1]==b[1])
           return a[0]>b[0];
        return a[1] < b[1]; 
    }
};