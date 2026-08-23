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
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)
           return head;
        ListNode mid = mid(head);
        ListNode second = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(second);

        return merge(left,right);
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode ans = new ListNode();
        ListNode tail = ans;
        while(left!=null && right!=null){
            if(left.val<right.val){
                tail.next = left;
                left = left.next;
                tail = tail.next;
            }
            else{
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
        if(left!=null){
            tail.next = left;
        }
        if(right!=null){
            tail.next = right;
        }
        return ans.next;
    }
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}