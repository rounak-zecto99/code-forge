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
    public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
       for(ListNode head:lists){
        if(head!=null)
        heap.offer(head);
       }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(!heap.isEmpty()){
            ListNode dick = heap.poll();

            tail.next = dick;
            tail = tail.next;

            if(dick.next != null)
            heap.offer(dick.next);

            
        }
        tail.next = null;
        return dummy.next;
    }
}