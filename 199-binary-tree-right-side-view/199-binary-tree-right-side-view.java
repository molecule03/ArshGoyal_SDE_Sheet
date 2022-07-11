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
    public List<Integer> rightSideView(TreeNode root) {
        // List<Integer> list = new ArrayList<>();
        List<List<Integer>> wrapList = dfs(root);
        List<Integer> rightView = new ArrayList<Integer>();
        if(wrapList.size() == 0) return rightView;
        
        for(List<Integer> list : wrapList){
            rightView.add(list.get(list.size()-1));
        }
        // return list;
        return rightView;
    }
    
    private List<List<Integer>> dfs(TreeNode root){
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new ArrayList<>();
        if(root == null) return wrapList;
        
        queue.offer(root);
        
        while(! queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                
                list.add(queue.poll().val);
            }
            wrapList.add(list);
        }
        return wrapList;
    }
}