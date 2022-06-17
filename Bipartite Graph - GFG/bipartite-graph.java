// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
   public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
   {
       ArrayList<Node> nl=new ArrayList<>();
       for(int i=0;i<V;i++)
       {
           Node n=new Node(i);
           nl.add(n);
       }
       for(int i=0;i<V;i++)
       {
           Node u=nl.get(i);
           for(int j:adj.get(i))
           {
               Node v=nl.get(j);
               u.a.add(v);
           }
       }
       for(int i=0;i<V;i++)
       {
           Queue<Node> q=new LinkedList<>();
           
           Node n=nl.get(i);
           if(n.c!=-1)
               continue;
           n.c=0;
           q.add(n);
           while(!q.isEmpty())
           {
               Node u=q.remove();
               for(Node nc:u.a)
               {
                   if(nc.c==u.c)
                   {
                       return false;
                   }
                   else if(nc.c==-1)
                   {
                       nc.c=1-u.c;
                       q.add(nc);
                   }
               }
           }
       }
       return true;
   }
   class Node
   {
       int d;
       int c;
       ArrayList<Node> a;
       Node(int d)
       {
           this.d=d;
           this.c=-1;
           a=new ArrayList<Node>();
       }
   }
}