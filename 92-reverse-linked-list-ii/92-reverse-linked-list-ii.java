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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode pre = null;
        ListNode cur = head;
        
        while(left > 1){
            pre = cur;
            cur = cur.next;
            left--;
            right--;
        }
        
        System.out.println(cur.val);
        ListNode last = pre;
        ListNode now = cur;
        ListNode next = null;
        while(right > 0){
            next = now.next;
            now.next = last;
            last = now;
            now = next;
            right--;
        }
        
        // System.out.println(last.val);
        if(pre != null){
            pre.next = last;
        }
        else{
            head = last;
        }
        
        cur.next = now;
        
        return head;
    }
}