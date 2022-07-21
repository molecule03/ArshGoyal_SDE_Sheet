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
        
        ListNode cur = head;
        
        int i = 1;
        while(i < left){
            cur = cur.next;
            i++;
        }
        
        List<Integer> list = new ArrayList<>();
        while(i <= right){
            list.add(cur.val);
            cur = cur.next;
            i++;
        }
        
        // System.out.println(list);
        Collections.reverse(list);
        
        cur = head;
        i = 1;
        while(i < left){
            cur = cur.next;
            i++;
        }
        
        int j=0;
        while(i <= right){
            cur.val = list.get(j++); 
            cur = cur.next;
            i++;
        }
        
        return head;
    }
}