// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

class Solution
{
  public:
        int getCount (string S, int N)
        {
            //code here.
            unordered_map<char,int>ans;
            // for(auto it:S){
            //     ans[it]++;
            // }
            ans[S[0]]++;
            for(int i=1; i<S.size(); i++){
                if(S[i] != S[i-1]){
                     ans[S[i]]++;
                }
            }
            int cnt=0;
            for(auto i: ans){
                // cout<<i<<" ";
                if(i.second == N){
                    cnt++;
                }
            }
            return cnt;
        }
};

// { Driver Code Starts.
int main()
{
    int t; cin >> t;
    while (t--)
    {
        string s; cin >> s;
        int n; cin >> n;
        
        Solution ob;
        cout <<ob.getCount (s, n) << endl;
    }
}

// Contributed By: Pranay Bansal
  // } Driver Code Ends