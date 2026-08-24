/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // public ListNode reverse(ListNode head) {
    //     ListNode prev = null;
    //     ListNode pres = head;
    //     ListNode next;
    //     while (pres != null) {
    //         next = pres.next;
    //         pres.next = prev;
    //         prev = pres;
    //         pres = next;
    //     }
    //     return prev;
    // }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //  l1 = reverse(l1);
    //  l2 = reverse(l2);

     ListNode dummy = new ListNode(0);

     ListNode tail = dummy;
     int carry =0;
     int val = 0;

     while(l1!=null || l2!=null || carry==1){
        if(l1!=null && l2!=null){
             val = l1.val + l2.val+carry;
             ListNode next = new ListNode(val%10);
             carry = val/10;
             l1 = l1.next;
             l2 = l2.next;
             tail.next = next;
             tail = tail.next;

        }
        else if(l1!=null){
             val = l1.val+carry;
              ListNode next = new ListNode(val%10);
             carry = val/10;
             l1 = l1.next;
             tail.next = next;
             tail = tail.next;
        }
         else if(l2!=null){
             val = l2.val+carry;
              ListNode next = new ListNode(val%10);
             carry = val/10;
             l2 = l2.next;
             tail.next = next;
             tail = tail.next;
        }
        else{
           ListNode next = new ListNode(carry);
             carry = carry/10;
             tail.next = next;
             tail = tail.next;
        }
     }
    return dummy.next;
    }
}