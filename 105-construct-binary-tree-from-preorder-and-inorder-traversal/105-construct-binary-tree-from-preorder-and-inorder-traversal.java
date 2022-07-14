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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        
    TreeNode root = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        
        return root;
    }
    
    private TreeNode build(int[] preorder, int preS, int preE,
                                 int[] inorder,  int inS,  int inE,
                                 Map<Integer, Integer> map){
        
        if(preS > preE || inS > inE) return null;
        
        TreeNode root = new TreeNode(preorder[preS]);
        
        // System.out.println(root.val);
        int inRoot = map.get(root.val);
        int num = inRoot - inS;
        
        root.left = build(preorder,preS+1 ,preE+num , inorder, inS, inS+num-1, map);
        
        root.right = build(preorder,preS+num+1 ,preE , inorder, inS+num+1 ,inE , map);
        
        
        return root;
    }
}