// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


void addFraction(int num1, int den1, int num2,
                 int den2);

int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        int a,b,c,d,resultNum,resultDen;
        cin>>a>>b>>c>>d;
        addFraction(a,b,c,d);

    }
}
// } Driver Code Ends


/*You are required to complete this function*/
int gcd(int a,int b){
    if(a==0)return b;
    return gcd(b%a,a);
}
void addFraction(int num1, int den1, int num2,int den2)
{
    //Your code here
    int n=(num1*den2)+(num2*den1);
    int d=(den1*den2);
    int g=gcd(n,d);
    cout<<n/g<<"/"<<d/g<<endl;
 }