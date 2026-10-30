
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find middle
        ListNode middle = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        // 2. Split the list
        ListNode second = middle.next;
        middle.next = null;

        // 3. Reverse second half
        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // 4. Merge two halves
        while (prev != null) {
            ListNode n1 = head.next;
            ListNode n2 = prev.next;

            head.next = prev;
            prev.next = n1;

            head = n1;
            prev = n2;
        }
    }
}
