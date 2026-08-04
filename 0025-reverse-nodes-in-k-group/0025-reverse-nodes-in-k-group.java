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
    public ListNode rev(ListNode head ,int k , ListNode node){
        if (head == null || k == 1){
             return head;}
         int j =k;
         ListNode check = head;
         while(j>0){
          if(check == null){
            return head;
          }
          check = check.next;
          j--;
         } 
         j =k;
        
        ListNode prev = head;
        ListNode pres = prev.next;
        ListNode next = pres.next;
        prev.next = null;
        head =prev; 
        while(j>1){
            if(pres == null){
              return head;
            }
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
            
            j--;
        }
        head.next= rev(pres, k , head);
         return prev;

        
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        head = rev(head , k , head);
        return head;
    }
}