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
    public ListNode removeNodes(ListNode head) {
        
        if(head == null) return head;

        head = reverse(head);

        ListNode temp = head;
        int max = temp.val;
        while(temp!=null && temp.next!=null){
           if(temp.next.val < max){
            temp.next = temp.next.next;
           }
           else{
           
            temp = temp.next;
            max = temp.val;
           }
       
        }

       head = reverse(head);
       return head;

    }
    public ListNode reverse( ListNode head){
          ListNode prev = null;
          ListNode pres = head;
        while(pres!=null){
            ListNode next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;

        }
        return prev;
    }
}