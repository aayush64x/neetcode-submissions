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
    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode prev = null; 
        ListNode first = null;
        if(head == null) { 
            return null;
        }
        while(head != null){
            node = head; 
            prev = head.next;  
            node.next = first;
            first = node; 
            head = prev; 
        }
        return node; 
    }
}
