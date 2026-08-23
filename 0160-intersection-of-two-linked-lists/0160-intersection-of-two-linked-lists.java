/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        int change = 2;
        ListNode headA = A;
        ListNode headB = B;
        while(headA!=null && headB!= null){
            if(headA == headB)
              return headA;
            headA = headA.next;
            headB = headB.next;

            
                if(change>0 && headA == null){
                    headA = B;
                    change--;
                }
                if(change>0 && headB == null){
                    headB = A;
                    change--;
                }
            
        }
        return null;
    }
}