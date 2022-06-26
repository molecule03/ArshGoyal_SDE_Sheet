class Solution {
        
public:
    bool adj(string password){
        int n=password.size();
            for(int i=0;i+1<n;i++)
                if(password[i]==password[i+1])return true;
                return false;
            
        }
    bool strongPasswordCheckerII(string password) {
       
        int n=password.size();
        if(n<8) return false;
        
        string sp_ch="!@#$%^&*()-+";
        map<char,int>ms;
        for(auto ch:sp_ch) 
            ms[ch]++;
        
         int dig=0,up=0,lo=0,spl=0;
        for(int i=0; i<n;i++){
           
            if(password[i] >= '0' && password[i] <= '9') dig++;
            else if(password[i] >= 'A' && password[i] <='Z') up++;
            else if(password[i] >='a' && password[i] <= 'z') lo++;
            else if (ms.find(password[i])!=ms.end()) spl++;
            
        }
        
        
        if(adj(password) || (dig==0) || (up==0) || (lo==0) || (spl==0))
            return false;
        
        
        return true;
    }
};