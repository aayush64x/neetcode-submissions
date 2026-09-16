class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = null;       // this plays the role you were missing: "the node before"
        while (head != null) {
            ListNode temp = head.next;  // save where head points BEFORE you overwrite it
            head.next = node;           // flip head's pointer backward to node
            node = head;                 // node advances to where head is now
            head = temp;                 // head advances to where it used to point
        }

        return node;
    }
}