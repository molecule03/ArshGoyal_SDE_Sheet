class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int n = cardPoints.size();
        
        int lSum = 0;
        int rSum = 0;
        for(int i=n-1; i>=n-k; i--){  // taking sum of last k cards
            rSum += cardPoints[i];
        }
        
        // int left = 0;
        // int right = k;
        
        int maxPoints = rSum;
        int i=0, j=(n-k);
        for(int l=0; l<k; l++){
            int points = 0;
           
            lSum += cardPoints[i++];
            rSum -= cardPoints[j++];
            
            points = lSum+rSum;
            
            maxPoints = max(points, maxPoints);
        }
        
        maxPoints = max(lSum, maxPoints);
        
        return maxPoints;
    }
};