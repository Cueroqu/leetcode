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
        int previous = head.val;
        ListNode cur = head.next, pcur = head;
        while (cur != null) {
            if (cur.val == previous) {
                ListNode tmp = cur.next;
                while (tmp != null && tmp.val == previous) tmp = tmp.next;
                pcur.next = tmp;
                cur = null;
                if (tmp != null) {
                    previous = tmp.val;
                    cur = tmp.next;
                    pcur = tmp;
                }
            } else {
                previous = cur.val;
                pcur = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}