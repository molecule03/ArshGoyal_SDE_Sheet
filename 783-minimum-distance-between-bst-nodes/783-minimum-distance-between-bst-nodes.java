/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
      int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        
        // System.out.println(list);
        int min = Integer.MAX_VALUE;
        for(int i=1; i<list.size(); i++){
            min = Math.min(min, (list.get(i)-list.get(i-1)));
        }
        return min;
    }
    
    private void dfs(TreeNode root, List<Integer>list){
        if(root == null) return;
        
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}