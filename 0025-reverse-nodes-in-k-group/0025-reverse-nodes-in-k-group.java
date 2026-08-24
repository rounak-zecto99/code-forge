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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
        return head;

        return rev(head,k,head,k);
    }
    public ListNode rev(ListNode head, int k,ListNode node,int curr){

        if(head == null){
           return node;
        }
        if(curr == 1){
             ListNode prev= node;
             ListNode pres = node.next;
             
             while(prev!=head){
                ListNode next = pres.next;
                pres.next = prev;
                prev = pres;
                pres = next;

             }
             curr = k;
             node.next =rev(pres,k,pres,curr);
             return prev;
        }
        return rev(head.next,k,node,curr-1);
    }
}