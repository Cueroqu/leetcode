/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode nhead = new RandomListNode(head.label), cur = head, tmp, ncur, pre;
        ncur = nhead;
        while (cur.next != null) {
            tmp = new RandomListNode(cur.next.label);
            ncur.next = cur.next;
            pre = cur;
            cur = cur.next;
            pre.next = ncur;
            ncur = tmp;
        }
        cur.next = ncur;
        cur = head;
        while (cur != null) {
            if (cur.random == null) cur.next.random = null;
            else cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        ncur = nhead;
        tmp = null;
        while (cur != null) {
            ncur = cur.next;
            if (ncur.next != null) tmp = ncur.next.next;
            else tmp = null;
            cur.next = ncur.next;
            ncur.next = tmp;
            cur = cur.next;
            ncur = ncur.next;
        }
        return nhead;
    }
}