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
    public ListNode partition(ListNode head, int x) {
        
        // ListNode dum = new ListNode();
        // dum.next = head;
        
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                small.next = new ListNode(cur.val);
                small = small.next;
            }
            else{
                large.next = new ListNode(cur.val);
                large = large.next;
            }
            cur = cur.next;
        }

        small.next = largeHead.next;
        
        return smallHead.next;
    }
}