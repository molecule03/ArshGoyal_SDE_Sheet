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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution {
    // Function to find the minimum number of swaps required to sort the array.
   public int minSwaps(int nums[]){
        int n = nums.length;
        int arr[] = nums.clone();
        Arrays.sort(arr);
        Graph graph = new Graph(n);
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++)
             hm.put(nums[i], i);
        for (int i = 0; i < n; i++){
             graph.addEdge(hm.get(arr[i]), i);
        }
     return method2(graph.adj, n);
    }
    int method2(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean visited[] = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() != 0)
                if (!visited[i]) {
                    int u = i;
                    int v = 0;
                    int count = 0;
                    while (true) {
                        visited[u] = true;
                        v = adj.get(u).get(0);
                        u = v;
                        count++;
                        if (u == i)
                            break;
                    }
                    res += count - 1;
                }
        }

        return res;
    }
}
class Graph {
    int V;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int v) {
        V = v;
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
    }

    void addEdge(int u, int v) {
        if(u==v) return;
        adj.get(u).add(v);
    }
}