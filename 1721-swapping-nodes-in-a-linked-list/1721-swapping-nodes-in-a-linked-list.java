class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        ListNode last = head;

        while(--k != 0){
            last = last.next;
        }
        first = last;

        while(last.next != null){
            second = second.next;
            last = last.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}