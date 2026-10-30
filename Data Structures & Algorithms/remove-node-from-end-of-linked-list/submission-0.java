class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode reversed = reverseList(head);
        int count = 1;

        ListNode dummy = new ListNode();
        dummy.next = reversed;

        ListNode tail = dummy;

        while (reversed != null) {

            if (count == n) {
                tail.next = reversed.next;
            } else {
                tail = reversed;
            }

            reversed = reversed.next;
            count++;
        }

        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}