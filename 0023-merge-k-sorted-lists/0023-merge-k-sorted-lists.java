class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> heap =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!heap.isEmpty()) {

            ListNode node = heap.poll();

            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                heap.offer(node.next);
            }
        }

        tail.next = null;

        return dummy.next;
    }
}