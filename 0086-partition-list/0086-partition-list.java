class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(0);
        ListNode dlower = lower;

        ListNode higher = new ListNode(0);
        ListNode dhigher = higher;

        ListNode traversal = head;

        while (traversal != null) {
            if (traversal.val < x) {
                lower.next = traversal;
                lower = lower.next;
            } else {
                higher.next = traversal;
                higher = higher.next;
            }
            traversal = traversal.next;
        }
        higher.next = null;
        lower.next = dhigher.next;
        return dlower.next;

    }
}