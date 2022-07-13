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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> wrapList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return wrapList;
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            List<Integer> list = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                
                sum += q.peek().val;
                list.add(q.poll().val);
            }
            
            wrapList.add(sum/size);
        }

        return wrapList;
    }
}