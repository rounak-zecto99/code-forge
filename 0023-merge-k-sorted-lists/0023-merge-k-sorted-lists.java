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
        for(int i=0; i<lists.length ; i++){
           ListNode head = lists[i];
            while(head!=null){
                heap.offer(head);
                head = head.next;
            }
        }
        ListNode head = heap.poll();
        ListNode tail = head;
        while(!heap.isEmpty()){
            tail.next = heap.poll();
            tail = tail.next;
        }
        if(tail!=null)
        tail.next = null;
        return head;
    }
}