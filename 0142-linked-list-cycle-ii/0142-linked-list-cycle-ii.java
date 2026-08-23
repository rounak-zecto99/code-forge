/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode cycleLength(ListNode slow,ListNode fast,ListNode head){
        int counter=0;

        do{
            slow = slow.next;
            counter++;
        } while(slow!=fast);

        fast = head;
        slow = head;
        while(counter>0){
         fast = fast.next;
         counter--;
        }
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;

           if(slow == fast)
           return cycleLength(slow,fast,head);
        }
        return null;
    }
}