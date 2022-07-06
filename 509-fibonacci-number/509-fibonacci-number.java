class Solution {

int dp[31];
public: int fib(int n) {
        if(n <= 1) return n;
    
        if(dp[n] != 0){
            return dp[n];
        }
        int sum = fib(n-1)+fib(n-2);
        dp[n] = sum;
        
        return sum;
    }
};