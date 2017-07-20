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
    public ListNode getNode(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) return l1;
        return l2;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null; 
        ListNode ret = getNode(l1, l2), tmp, cur;
        if (ret == l1) l1 = l1.next;
        else l2 = l2.next;
        cur = ret;
        while (l1 != null || l2 != null) {
            if (l2 == null || (l1 != null && l1.val < l2.val)) {
                tmp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur.next = tmp;
            cur = cur.next;
        }
        return ret;
    }
}