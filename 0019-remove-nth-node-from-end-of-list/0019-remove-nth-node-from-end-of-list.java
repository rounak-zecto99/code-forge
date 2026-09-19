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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        ListNode curr = dummy;

        while(n>=0){
            temp = temp.next;
            n--;
        }
        while(temp!=null){
            temp = temp.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}