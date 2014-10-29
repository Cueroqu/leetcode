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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, fhead = new ListNode(0), next = head.next, pre = head, tmp, search;
        fhead.next = head;
        boolean set;
        for (int i = 1; next != null; ++i) {
            cur = next;
            search = fhead;
            set = false;
            for (int j = 0; j < i; ++j, search = search.next) {
                if (search.next.val > cur.val) {
                    next = cur.next;
                    pre.next = next;
                    tmp = search.next;
                    search.next = cur;
                    cur.next = tmp;
                    set = true;
                    break;
                }
            }
            if (!set) {
                pre = cur;
                next = cur.next;
            }
        }
        return fhead.next;
    }
}