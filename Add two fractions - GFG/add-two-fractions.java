// { Driver Code Starts
import java.util.*;

class Fraction_Addition
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			GfG g = new GfG();
			g.addFraction(a,b,c,d);
		T--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this function*/
class GfG
{
    int gcd(int a, int b){
        if(a==0)
        return b;
        
        return gcd(b%a, a);
    }
    
    void addFraction(int num1, int den1, int num2, int den2)
    {
        int mod = 1000000000+9;
        // Your code here
        int nx = (num1*den2)+(num2*den1);
    int dx = (den1*den2);
    
    int g = gcd(nx, dx);
    
    System.out.println(nx/g+"/"+dx/g);
    }
}

    //  1     2      (5*1)+(2*10)  nx
    // 10    5         10 * 5     dx