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
    List<Integer> list;
    public void flatten(TreeNode root) {
        if(root == null) return;
        list = new ArrayList<>();
        
        dfs(root);
        
        // System.out.println(list);
        root.left = null;
        root.right = null;
        
        for(int i=1; i<list.size(); i++){
            TreeNode cur = new TreeNode(list.get(i));
            root.right = cur;
            root = root.right;
        }
        
    }
    
    private void dfs(TreeNode root){
        if(root == null) return;
        
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}