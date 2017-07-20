/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode shead = null, si = null, ohead = null, oi = null, cur = head;
        if (head == null || head.next == null) return head;
        while (cur != null) {
            if (cur.val < x) {
                if (shead == null) {
                    shead = si = cur;
                } else {
                    si.next = cur;
                    si = si.next;
                }
            } else {
                if (ohead == null) {
                    ohead = oi = cur;
                } else {
                    oi.next = cur;
                    oi = oi.next;
                }
            }
            cur = cur.next;
        }
        if (shead == null) {
            oi.next = null;
            return ohead;
        }
        si.next = ohead;
        if (ohead != null) oi.next = null;
        return shead;
    }
}