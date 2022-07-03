/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int mat[][] = new int[m][n];
        
        ListNode cur = head;
        int colB = 0;
        int colE = n-1;
        int rowB = 0;
        int rowE = m-1;
        
        while(colB <= colE && rowB <= rowE){
            
            for(int i=colB; i<=colE; i++){
                if(cur == null){
                    mat[rowB][i] = -1;
                }else{
                    mat[rowB][i] = cur.val;
                    cur = cur.next;
                }
            }
            rowB++;
            
            
            for(int i=rowB; i<=rowE; i++){
                if(cur == null){
                    mat[i][colE] = -1;
                }else{
                    mat[i][colE] = cur.val;
                    cur = cur.next;
                }
            }
            colE--;
            
            if(rowB <= rowE){
            for(int i=colE; i>=colB; i--){
                if(cur == null){
                    mat[rowE][i] = -1;
                }else{
                    mat[rowE][i] = cur.val;
                    cur = cur.next;
                }
            }}
            rowE--;
            
            
            if(colB <= colE){
            for(int i=rowE; i>=rowB; i--){
                if(cur == null){
                    mat[i][colB] = -1;
                }else{
                    mat[i][colB] = cur.val;
                    cur = cur.next;
                }
            }}
            colB++;
            
            
        }
        
        return mat;
    }
}