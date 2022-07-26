/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        TreeNode Node = getNode(root, p, q);
        // TreeNode qq = getNode( root, q);
        // System.out.println(pp.val+" "+qq.val);
        
        return Node;
    }
    
    private TreeNode getNode(TreeNode root, TreeNode p, TreeNode q){
        if(root== null ) return null;
        
        if(root.val == q.val || root.val == p.val) return root;
        // System.out.println(root.val+" "+target.val);
        
       TreeNode left = getNode(root.left, p, q);
       TreeNode right = getNode(root.right, p, q);
        
        // // return (left.val == target.val) ? left : right; 
        // return left;
        if(left != null && right != null) return root;
        
        if(left == null)
            return right;
        else
            return left;
    }
}