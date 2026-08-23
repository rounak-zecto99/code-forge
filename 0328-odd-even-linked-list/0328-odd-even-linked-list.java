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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
        return head;

        ListNode tail = head;
        ListNode second = head.next;
        ListNode dum = second;
        
        while(dum!=null && dum.next!=null && tail.next!=null){
        
            tail.next = tail.next.next;
            dum.next = dum.next.next;

            tail = tail.next;
            dum = dum.next;
        }
        tail.next = second;

        return head;
    }
}