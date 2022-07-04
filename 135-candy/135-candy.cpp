class Solution {
public:
    int candy(vector<int>& ratings) {
        
        int n = ratings.size();
        vector<int> choc(n ,1); 
        // Arrays.fill(choc, 1);
        
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                choc[i] = choc[i-1]+1;
            }
        }
        
        for(int i=n-1; i>0; i--){
            if(ratings[i] < ratings[i-1]){
                choc[i-1] = max(choc[i]+1, choc[i-1]);
            }
        }
        
        // System.out.println(Arrays.toString(choc));
        
        int noOfChoc = 0;
        for(int i : choc){
            noOfChoc += i;
        }
        
        return noOfChoc;
    }
};