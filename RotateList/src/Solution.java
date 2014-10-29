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
    public ListNode rotateRight(ListNode head, int n) {
        int  i, j, length = 0;
        ListNode cur, ncur;
        if (head == null || head.next == null) return head;
        for (cur = head; cur != null; cur = cur.next) {
            ++length;
        }
        n %= length;
        if (n == 0) return head;
        for (i = 0, cur = head; i < n; ++i) cur = cur.next;
        ++i;
        for (j = 0, ncur = head; i < length; ++j, ++i) {
            ncur = ncur.next;
            cur = cur.next;
        }
        cur.next = head;
        head = ncur.next;
        ncur.next = null;
        return head;
    }
}