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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
         ListNode prev = null;
         ListNode pres = slow.next;
         ListNode next = pres.next;
         slow.next = null;
         fast = head.next;

         while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
         }

         while(prev != null || fast != null){
            if(prev!=null){
            head.next = prev;
            head = head.next;
            prev = prev.next;
            }
            if(fast != null){
            head.next = fast;
            head = head.next;
            fast = fast.next;
            }
         }
    }
}