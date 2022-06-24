// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Trie {
    Trie[] childs = new Trie[26];
    List<String> anagrams = new ArrayList<>();
    boolean isEnd;
}
class Solution {
    public List<List<String>> result = new ArrayList<>();
    public Trie root = new Trie();
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        insert(root, string_list);
        dfs(root);
        return result;
    }
    public void insert(Trie curr, String[] string_list) {
        for(int i = 0; i < string_list.length; i++) {
            String word = string_list[i];
            char[] tempArr = word.toCharArray();
            Arrays.sort(tempArr);
            String sortedWord = new String(tempArr);
            curr = root;
            for(int j = 0; j < sortedWord.length(); j++) {
                char ch = sortedWord.charAt(j);
                if(curr.childs[ch - 'a'] == null) curr.childs[ch - 'a'] = new Trie();
                curr = curr.childs[ch - 'a'];
            }
            curr.isEnd = true;
            curr.anagrams.add(word);
        }
    }
    public void dfs(Trie curr) {
        if(curr.isEnd) result.add(curr.anagrams);

        for(int i = 0; i < 26; i++) {
            if(curr.childs[i] != null) dfs(curr.childs[i]);
        }
    }
}
