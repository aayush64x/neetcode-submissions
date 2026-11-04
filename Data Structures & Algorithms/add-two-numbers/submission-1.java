class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int val = carry;

            if (l1 != null) val += l1.val;
            if (l2 != null) val += l2.val;

            carry = val / 10;
            int digit = val % 10;

            ListNode node = new ListNode(digit);
            current.next = node;
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}