class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        long n = (long)prices.size();
        long count = 0;
        long cur = 0;
        for(int i=1; i<n; i++){
            if(prices[i-1]-prices[i] == 1){
                cur++;
                count += cur;
            }
            else{
                cur = 0;
            }
        }
        
        return count + n;
    }
};