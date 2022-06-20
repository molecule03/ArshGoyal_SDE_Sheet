class Solution {
public:
    int maxScore(vector<int>& num, int k) {
        int n = num.size();
        
        int lSum = 0;
        int rSum = 0;
        for(int i=n-1; i>=n-k; i--){
            rSum += num[i];
        }
        // System.out.println(rSum);
        
        int left = 0;
        int right = k;
        
        int maxScore = rSum;
        int i=0, j=(n-k);
        while(left <= k-1 && right >= 1){
            int sum = 0;
           
            lSum += num[i++];
            rSum -= num[j++];
            
            sum = lSum+rSum;
            
            maxScore = max(sum, maxScore);
            left++;
            right--;
        }
        
        maxScore = max(lSum, maxScore);
        
        return maxScore;
    }
};