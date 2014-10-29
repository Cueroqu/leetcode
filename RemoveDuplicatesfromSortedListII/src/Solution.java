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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head.next, fhead = new ListNode(0), pcur;
        fhead.next = head;
        pcur = fhead;
        int value = head.val;
        while (cur != null) {
            if (value == cur.val) {
                ListNode tmp = cur;
                while (tmp != null && tmp.val == value) tmp = tmp.next;
                pcur.next = tmp;
                cur = null;
                if (tmp != null) {
                    value = tmp.val;
                    cur = tmp.next;
                }
            } else {
                value = cur.val;
                pcur = pcur.next;
                cur = cur.next;
            }
        }
        return fhead.next;
    }
}