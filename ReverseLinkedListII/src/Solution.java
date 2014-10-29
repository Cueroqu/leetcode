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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) return head;
        ListNode fhead = new ListNode(0);
        fhead.next = head;
        ListNode cur = fhead, pre = null, rhead = null, ppre = null, tmp;
        int index = 0, start = 0;
        while (cur != null) {
            switch(start) {
                case 0:
                    ppre = cur;
                    cur = cur.next;
                    ++index;
                    if (index == m) {
                        rhead = pre = cur;
                        start = 1;
                    }
                    break;
                case 1:
                    tmp = cur;
                    cur = cur.next;
                    tmp.next = pre;
                    pre = tmp;
                    ++index;
                    if (index > n) {
                        ppre.next = pre;
                        rhead.next = cur;
                        start = 2;
                    }
                    break;
                case 2:
                    break;
            }
            if (start == 2) break;
        }
        return fhead.next;
    }
}