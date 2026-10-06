class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
        return head;

        ListNode prev = head;
        ListNode pres = head.next;
        ListNode next = pres.next;

        pres.next = prev;

        head.next = swapPairs(next);

        return pres;
    }
}