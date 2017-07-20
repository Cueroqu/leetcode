/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                for (fast = head; fast != slow; fast = fast.next, slow = slow.next) ;
                return fast;
            }
        }
        return null;
    }
}