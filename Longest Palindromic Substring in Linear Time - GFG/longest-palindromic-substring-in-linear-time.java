// { Driver Code Starts
//Initial Template for Java

import java.util.*;

class GfG
{
	public static void main(String[] args)
	{	
	    Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-- > 0)
		{
			String text = sc.next();
			solution x = new solution();
			System.out.println(x.LongestPalindromeSubString(text));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class solution
{
 static String LongestPalindromeSubString(String s)
   {
     
       int strLen = 2 * s.length() + 3;
       char[] sChars = new char[strLen];

       /*
        * To ignore special cases at the beginning and end of the array
        * "abc" -> @ # a # b # c # $
        * "" -> @#$
        * "a" -> @ # a # $
        */
       sChars[0] = '@';
       sChars[strLen - 1] = '$';
       int t = 1;
       for (char c : s.toCharArray()) {
           sChars[t++] = '#';
           sChars[t++] = c;
       }
       sChars[t] = '#';

       int maxLen = 0;
       int start = 0;
       int maxRight = 0;
       int center = 0;
       int[] p = new int[strLen]; // i's radius, which not includes i
       for (int i = 1; i < strLen - 1; i++) {
           if (i < maxRight) {
               p[i] = Math.min(maxRight - i, p[2 * center - i]);
           }

           // expand center
           while (sChars[i + p[i] + 1] == sChars[i - p[i] - 1]) {
               p[i]++;
           }

           // update center and its bound
           if (i + p[i] > maxRight) {
               center = i;
               maxRight = i + p[i];
           }

           // update ans
           if (p[i] > maxLen) {
               start = (i - p[i] - 1) / 2;
               maxLen = p[i];
           }
       }

       return s.substring(start, start + maxLen);
      
   }
}
