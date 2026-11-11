class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;
        ListNode cur = dummy;

        while (n-- >= 0) {
            temp = temp.next;
        }

        while (temp != null) {
            temp = temp.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;

    }
}