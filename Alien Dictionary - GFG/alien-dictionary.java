// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
   void dfs(HashMap<Character,Integer> vis,char ch,HashMap<Character,String> map,StringBuilder ans){
       if(vis.containsKey(ch)==false){
           // System.out.println(ch);
           ans.append(ch);
           vis.put(ch,1);
           return;
       }
       if(vis.get(ch)==1) return ;
       vis.put(ch,1);
       for(int i = 0;i<map.get(ch).length();i++){
           char curr = map.get(ch).charAt(i);
           
           dfs(vis,curr,map,ans);   
       }
       // System.out.println(ch);
       ans.append(ch);
   }
   public String findOrder(String [] dict, int N, int K){
       HashMap<Character,String> map = new HashMap<>();
       for(int i = 0;i<dict.length-1;i++){
           int j = 0;
           int k = 0;
           while(j<dict[i].length() && k<dict[i+1].length()){
               if(dict[i].charAt(j)==dict[i+1].charAt(k)){
                   j++;
                   k++;
               }
               else{
                   if(map.containsKey(dict[i+1].charAt(k))){
                   map.put(dict[i+1].charAt(k),map.get(dict[i+1].charAt(k))+dict[i].charAt(j));
               }else map.put(dict[i+1].charAt(k),"" + dict[i].charAt(j));
               break;
               }
           }
       }
       Set<Character> Key = map.keySet();
       char key[] = new char[Key.size()];
       int k = 0;
       for(Character ch : Key){
           key[k++] = ch;
       }
       // System.out.println(Arrays.toString(key));
       // System.out.println(map);
       HashMap<Character,Integer> vis = new HashMap<Character,Integer>();
       for(int i = 0;i<key.length;i++){
           vis.put(key[i],-1);
       }
       StringBuilder ans = new StringBuilder();
       for(int i = 0;i<key.length;i++){
           if(vis.get(key[i])==-1){
               dfs(vis,key[i],map,ans);
           }
       }
       // System.out.println(ans);
       return ans.toString();
   }
}